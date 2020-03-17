package main.models;

import main.encounters.alien.AbstractAliens;
import main.models.animals.Animal;
import main.models.animals.sea.SeaAnimal;
import main.models.managers.OutputManager;
import main.models.nodes.AbstractNode;
import main.models.nodes.Grass;
import main.models.nodes.Village;
import main.models.nodes.biomes.AbstractBiome;
import main.models.nodes.biomes.Grasslands;
import main.models.resources.natural.Flowers;
import main.utilities.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Board {

    private Village village;

    private Integer gridXMax;
    private Integer gridYMax;
    private ArrayList<AbstractNode> grid;

    private ArrayList<AbstractAliens> aliens;
    private Map<Flowers,Integer> flowers;
    private ArrayList<Animal> animals;
    private ArrayList<SeaAnimal> fish;

    private Integer trees;
    private Integer stone;
    private Integer clay;
    private Integer copperOre;
    private Integer ironOre;
    private Integer goldOre;
    private Integer gems;
    private Integer rocks;
    private Integer sand;
    private Integer spacegoo;
    private Integer healingItems;

    public Board(AbstractBiome startingBiome, int xMax, int yMax) {
        this.village = new Village(startingBiome);
        this.village.setxPos(0);
        this.village.setyPos(0);
        this.gridXMax = xMax;
        this.gridYMax = yMax;
        this.grid = new ArrayList<>();
        this.grid.add(this.village);
        this.trees = 0;
        this.stone = 0;
        this.clay = 0;
        this.copperOre = 0;
        this.ironOre = 0;
        this.gems = 0;
        this.healingItems = 0;
        this.rocks = 0;
        this.sand = 0;
        this.spacegoo = 0;
        this.goldOre = 0;
        this.aliens = new ArrayList<>();
        this.flowers = new HashMap<>();
        this.animals = new ArrayList<>();
        this.fish = new ArrayList<>();
    }

    public AbstractNode getRandomRegion() {
        int x = 0;
        int y = 0;
        boolean canAdd = true;
        do {
            canAdd = true;
            for (AbstractNode space : grid) {
                if (space.getyPos().equals(y) && space.getxPos().equals(x)) {
                    canAdd = false;
                    break;
                }
            }
            if (!canAdd) {
                x = ThreadLocalRandom.current().nextInt(0, gridXMax);
                y = ThreadLocalRandom.current().nextInt(0, gridYMax);
            }
        } while (!canAdd);
        return getRandomRegion(x, y);
    }

    public AbstractNode getRandomRegion(int x, int y) {
        int randTrees = ThreadLocalRandom.current().nextInt(1, 20);
        int randStones = ThreadLocalRandom.current().nextInt(1, 15);
        int randRocks = ThreadLocalRandom.current().nextInt(1, 10);
        return new Grass(x, y, randTrees, randStones, randRocks, new Grasslands());
    }

    public Boolean discover(AbstractNode region) {
        return addGridSpace(region);
    }

    public Boolean addGridSpace(AbstractNode space) {
        boolean canAdd = true;
        for (AbstractNode a : grid) {
            if (a.getxPos().equals(space.getxPos()) && a.getyPos().equals(space.getyPos())) {
                canAdd = false;
                break;
            } else if (space.getxPos() >= gridXMax || space.getyPos() >= gridYMax) {
                canAdd = false;
                break;
            }
        }
        if (canAdd) {
            this.grid.add(space);
            if (space.hasArtifact()) {
                village.getInventory().addItem(space.getArtifact());
                if (GameStrings.startsWithVowel(space.getArtifact().getName())) {
                    OutputManager.addToTop("Found an " + space.getArtifact().getName() + " on a newly discovered space!");
                } else {
                    OutputManager.addToTop("Found a " + space.getArtifact().getName() + " on a newly discovered space!");
                }
            }
            return true;
        }
        return false;
    }

    public void addAnimals(Animal animal, int amt) {
        for (int i = 0; i < amt; i++) {
            animals.add(animal.clone());
        }
    }

    public Village getVillage() {
        return village;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public Integer getTrees() {
        return trees;
    }

    public ArrayList<SeaAnimal> getFish() {
        return fish;
    }

    public Integer getRocks() {
        return rocks;
    }

    public void setTrees(Integer trees) {
        this.trees = trees;
    }

    public void setRocks(Integer rocks) {
        this.rocks = rocks;
    }

    public void addFish(SeaAnimal fishToAdd, Integer amount){
        for (int i = 0; i < amount; i++) {
            fish.add((SeaAnimal) fishToAdd.clone());
        }
    }

    public void reduceTreesOnBoard(int amt) {
        this.trees -= amt;
        if (this.trees < 0) {
            this.trees = 0;
        }
    }
}
