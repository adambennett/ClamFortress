package clamFortress.models;

import clamFortress.encounters.alien.*;
import clamFortress.game.regions.*;
import clamFortress.models.animals.Animal;
import clamFortress.models.gridSpaces.*;
import clamFortress.models.resources.natural.Flowers;

import clamFortress.tech.eras.*;

import java.util.*;
import java.util.concurrent.*;

public class Board {

    private Village village;

    private Integer gridXMax;
    private Integer gridYMax;
    private ArrayList<AbstractGridSpace> grid;

    private ArrayList<AbstractAliens> aliens;
    private Map<Flowers,Integer> flowers;
    private Map<Animal,Integer> animals;

    private Integer trees;
    private Integer stone;
    private Integer clay;
    private Integer copperOre;
    private Integer ironOre;
    private Integer goldOre;
    private Integer gems;
    private Integer fish;
    private Integer rocks;
    private Integer sand;
    private Integer spacegoo;
    private Integer healingItems;

    public Board(AbstractRegion startingBiome, int xMax, int yMax) {
        this.village = new Village(startingBiome, new StoneAge());
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
        this.fish = 0;
        this.healingItems = 0;
        this.rocks = 0;
        this.sand = 0;
        this.spacegoo = 0;
        this.goldOre = 0;
        this.aliens = new ArrayList<>();
        this.flowers = new HashMap<>();
        this.animals = new HashMap<>();
    }

    public AbstractGridSpace getRandomRegion() {
        int x = 0;
        int y = 0;
        boolean canAdd = true;
        do {
            canAdd = true;
            for (AbstractGridSpace space : grid) {
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

    public AbstractGridSpace getRandomRegion(int x, int y) {
        int randTrees = ThreadLocalRandom.current().nextInt(1, 20);
        int randStones = ThreadLocalRandom.current().nextInt(1, 15);
        int randRocks = ThreadLocalRandom.current().nextInt(1, 10);
        return new GrassSpace(x, y, randTrees, randStones, randRocks);
    }

    public Boolean discover(AbstractGridSpace region) {
        return addGridSpace(region);
    }

    public Boolean addGridSpace(AbstractGridSpace space) {
        boolean canAdd = true;
        for (AbstractGridSpace a : grid) {
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
            return true;
        }
        return false;
    }

    public void addAnimals(Animal animal) {
        addAnimals(animal, 1);
    }

    public void addAnimals(Animal animal, int amt) {
        if (this.animals.containsKey(animal)) {
            this.animals.put(animal, this.animals.get(animal) + amt);
        } else {
            this.animals.put(animal, amt);
        }
    }

    public void addFlowers(Flowers flower) {
        addFlowers(flower, 1);
    }

    public void addFlowers(Flowers flower, int amt) {
        if (this.flowers.containsKey(flower)) {
            this.flowers.put(flower, this.flowers.get(flower) + amt);
        } else {
            this.flowers.put(flower, amt);
        }
    }

    public void addAlienEncounter(AbstractAliens a) {
        aliens.add(a);
    }

    public void reduceTreesOnBoard(Integer amountToCutDown){
        this.trees -= amountToCutDown;
        if(this.trees < 0){
            this.trees =0;
        }
    }

    public void reduceStoneOnBoard(Integer amountToMine){
        this.stone -= amountToMine;
        if(this.stone < 0){
            this.stone = 0;
        }
    }

    public void reduceCopperOreOnBoard(Integer amountToMine){
        this.copperOre -= amountToMine;
        if(this.copperOre < 0){
            this.copperOre = 0;
        }
    }

    public void reduceIronOreOnBoard(Integer amountToMine){
        this.ironOre -= amountToMine;
        if(this.ironOre < 0){
            this.ironOre = 0;
        }
    }

    public void reduceGemsOnBoard(Integer amountToMine){
        this.gems -= amountToMine;
        if(this.gems < 0){
            this.gems = 0;
        }
    }

    public void reduceFishOnBoard(Integer amountToMine){
        this.fish -= amountToMine;
        if(this.fish < 0){
            this.fish = 0;
        }
    }

    public void reduceHealingItemsOnBoard(Integer amountToUse){
        this.healingItems -= amountToUse;
        if(this.healingItems < 0){
            healingItems = 0;
        }
    }

    public void setTrees(Integer trees) {
        this.trees = trees;
    }

    public void setStone(Integer stone) {
        this.stone = stone;
    }

    public void setClay(Integer clay) {
        this.clay = clay;
    }

    public void setCopperOre(Integer copperOre) {
        this.copperOre = copperOre;
    }

    public void setIronOre(Integer ironOre) {
        this.ironOre = ironOre;
    }

    public void setGoldOre(Integer goldOre) {
        this.goldOre = goldOre;
    }

    public void setGems(Integer gems) {
        this.gems = gems;
    }

    public void setFish(Integer fish) {
        this.fish = fish;
    }

    public void setRocks(Integer rocks) {
        this.rocks = rocks;
    }

    public void setSand(Integer sand) {
        this.sand = sand;
    }

    public void setSpacegoo(Integer spacegoo) {
        this.spacegoo = spacegoo;
    }

    public void setHealingItems(Integer healingItems) {
        this.healingItems = healingItems;
    }

    public Village getVillage() {
        return village;
    }

    public ArrayList<AbstractGridSpace> getGrid() {
        return grid;
    }

    public ArrayList<AbstractAliens> getAliens() {
        return aliens;
    }

    public Map<Flowers, Integer> getFlowers() {
        return flowers;
    }

    public Map<Animal, Integer> getAnimals() {
        return animals;
    }

    public Integer getTrees() {
        return trees;
    }

    public Integer getStone() {
        return stone;
    }

    public Integer getClay() {
        return clay;
    }

    public Integer getCopperOre() {
        return copperOre;
    }

    public Integer getIronOre() {
        return ironOre;
    }

    public Integer getGoldOre() {
        return goldOre;
    }

    public Integer getGems() {
        return gems;
    }

    public Integer getFish() {
        return fish;
    }

    public Integer getRocks() {
        return rocks;
    }

    public Integer getSand() {
        return sand;
    }

    public Integer getSpacegoo() {
        return spacegoo;
    }

    public Integer getHealingItems() {
        return healingItems;
    }
}
