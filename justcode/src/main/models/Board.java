package main.models;

import main.encounters.alien.AbstractAliens;
import main.enums.*;
import main.models.animals.AbstractAnimal;
import main.models.animals.desert.*;
import main.models.animals.jungle.*;
import main.models.animals.land.*;
import main.models.animals.land.bears.*;
import main.models.animals.mountain.*;
import main.models.animals.sea.AbstractSeaAnimal;
import main.models.animals.tundra.*;
import main.models.items.*;
import main.models.managers.*;
import main.models.nodes.*;
import main.models.nodes.biomes.*;
import main.models.resources.*;
import main.models.resources.natural.Flowers;
import main.utilities.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Board extends GameObject {

    private Integer gridXMax;
    private Integer gridYMax;
    private Integer nextX;
    private Integer nextY;

    private final Integer startPopCap;
    private final AbstractBiome startBiome;
    private final Village village;
    private ArrayList<AbstractNode> grid;
    private ArrayList<AbstractAnimal> animals;
    private Map<AbstractResource, Integer> resources;

    public Board() {
        super("Fake Board", "The game board!");
        this.village = new Village();
        this.startPopCap = 0;
        this.startBiome = new BlankBiome();
    }

    public Board(AbstractBiome startingBiome, int xMax, int yMax, int popCap) {
        super("Game Board", "The game board!");
        this.village = new Village(startingBiome, popCap);
        this.village.setxPos(0);
        this.village.setyPos(0);
        this.gridXMax = xMax;
        this.gridYMax = yMax;
        this.grid = new ArrayList<>();
        this.grid.add(this.village);
        this.animals = new ArrayList<>();
        this.resources = new HashMap<>();
        this.startBiome = startingBiome;
        this.startPopCap = popCap;
        this.nextX = 0;
        this.nextY = 0;
        this.addAnimals(this.village.getAnimals());
        this.addResources(this.village.getResources());
    }

    public Boolean isBoardFull() {
        return (grid.size() >= (gridXMax * gridYMax)+1 || nextY > gridYMax);
    }

    public AbstractNode getRandomRegion(int nethermod) {
        int boardSize = gridXMax * gridYMax;
        if (grid.size() >= boardSize+1 || nextY > gridYMax) {
            return null;
        }
        return getRandomRegion(nextX, nextY, nethermod);
    }

    public AbstractNode getRandomRegion(int x, int y, int nethermod) {
        return NodeManager.getRandomNode(x, y, nethermod);
    }

    public Integer getNextX() {
        return nextX;
    }

    public Integer getNextY() {
        return nextY;
    }

    public AbstractNode getNodeAt(int x) {
        for (AbstractNode node : grid) {
            if (node.getxPos().equals(x) && node.getyPos().equals(0)) {
                return node;
            }
        }
        return null;
    }

    public AbstractNode getNodeAt(int x, int y) {
        for (AbstractNode node : grid) {
            if (node.getxPos().equals(x) && node.getyPos().equals(y)) {
                return node;
            }
        }
        return null;
    }

    public void discover(AbstractNode region) {
        addGridSpace(region);
    }

    public void addGridSpace(AbstractNode space) {
        this.grid.add(space);
        nextX++; if (nextX > gridXMax) { nextX = 0; nextY++; }
        if (space.hasArtifact()) {
            GameUtils.obtainArtifact(space.getArtifact());
        }
        if (space.hasItem()) {
            GameUtils.obtainItem(space.getItem());
        }
        if (!(space instanceof City)) {
            Game.getGameBoard().addResources(space.getResources());
            Game.getGameBoard().addAnimals(space.getAnimals());
        } else {
            GameManager.getInstance().getRaidable().add((City) space);
        }
    }

    public void addAnimals(Map<AbstractAnimal, Integer> animals) {
        for (Map.Entry<AbstractAnimal, Integer> entry : animals.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                this.animals.add(entry.getKey().clone());
                for (GameObject obj : Game.getModifierObjects()) {
                    obj.onAddAnimalToBoard(entry.getKey());
                }
            }
        }
    }

    public void addAnimals(AbstractAnimal animal, int amt) {
        for (int i = 0; i < amt; i++) {
            this.animals.add(animal.clone());
            for (GameObject obj : Game.getModifierObjects()) {
                obj.onAddAnimalToBoard(animal);
            }
        }
    }

    // RESOURCES     /////////////////////////////////////////////////////////////////////////////////////////////
    public Boolean hasEnoughOfResource(String resource, int amt) {
        if (Archive.getInstance().getRes(resource) != null) {
            AbstractResource res = Archive.getInstance().getRes(resource);
            if ((this.resources.get(res) != null)) {
                int check = this.resources.get(res);
                return check >= amt;
            }
        }
        return false;
    }

    public Integer totalResources() {
        return getAllResources().size();
    }

    public void addResources(ArrayList<AbstractResource> resources) {
            for (AbstractResource r : resources) {
                addResource(r);
            }
    }

    public void addResources(Map<AbstractResource, Integer> resources) {
            for (Map.Entry<AbstractResource, Integer> entry : resources.entrySet()) {
                if (this.resources.containsKey(entry.getKey())) {
                    this.resources.put(entry.getKey(), entry.getValue() + this.resources.get(entry.getKey()));
                } else {
                    this.resources.put(entry.getKey(), entry.getValue());
                }
            }
    }

    public void addResource(AbstractResource resource) {
        addResource(resource, 1);
    }

    public void addResource(AbstractResource resource, int amt) {
            if (this.resources.containsKey(resource)) {
                this.resources.put(resource, this.resources.get(resource) + amt);
            } else {
                this.resources.put(resource, amt);
            }
    }

    public AbstractResource removeRandomResource() {
        if (this.resources.size() > 0) {
            ArrayList<String> all = new ArrayList<>();
            for (Map.Entry<AbstractResource, Integer> entry : this.resources.entrySet()) {
                all.add(entry.getKey().getName());
            }
            AbstractResource output = Archive.getInstance().getRes(all.get(ThreadLocalRandom.current().nextInt(all.size())));
            this.resources.remove(output);
            return output;
        }
        return null;
    }

    public Integer removeResource(String resource) {
        return removeResource(resource, 0, true);
    }

    public Integer removeResource(String resource, int amt) {
        return removeResource(resource, amt, false);
    }

    private Integer removeResource(String resource, int amt, boolean all) {
        if (Archive.getInstance().getRes(resource) != null) {
            AbstractResource res = Archive.getInstance().getRes(resource);
            if ((this.resources.get(res) != null)) {
                if (all || this.resources.get(res) < amt) {
                    return this.resources.remove(res);
                }
                this.resources.put(res, this.resources.get(res) - amt);
            }
        }
        return 0;
    }

    public Boolean containsResource(String resource) {
        return Archive.getInstance().getRes(resource) != null && this.resources.containsKey(Archive.getInstance().getRes(resource));
    }

    public Integer getResource(String resource) {
        return Archive.getInstance().getRes(resource) != null ? this.resources.get(Archive.getInstance().getRes(resource)) : 0;
    }

    public Map<AbstractResource, Integer> getResources() {
        return resources;
    }

    public ArrayList<AbstractResource> getAllResources() {
        ArrayList<AbstractResource> output = new ArrayList<>();
        for (Map.Entry<AbstractResource, Integer> entry : this.resources.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                output.add(entry.getKey().clone());
            }
        }
        return output;
    }
    // END RESOURCES /////////////////////////////////////////////////////////////////////////////////////////////
    public ArrayList<City> getAllCities() {
        ArrayList<City> output = new ArrayList<>();
        for (AbstractNode node : this.grid) {
            if (node instanceof City) {
                output.add((City) node);
            }
        }
        return output;
    }

    public Village getVillage() {
        return village;
    }

    public ArrayList<AbstractAnimal> getAnimals() {
        return animals;
    }

    public ArrayList<AbstractDesertAnimal> getDesertAnimals() {
        ArrayList<AbstractDesertAnimal> toRet = new ArrayList<>();
        for (AbstractAnimal animal : animals) {
            if (animal instanceof AbstractDesertAnimal) {
                toRet.add((AbstractDesertAnimal) animal);
            }
        }
        return toRet;
    }

    public ArrayList<AbstractJungleAnimal> getJungleAnimals() {
        ArrayList<AbstractJungleAnimal> toRet = new ArrayList<>();
        for (AbstractAnimal animal : animals) {
            if (animal instanceof AbstractJungleAnimal) {
                toRet.add((AbstractJungleAnimal) animal);
            }
        }
        return toRet;
    }

    public ArrayList<AbstractBear> getBears() {
        ArrayList<AbstractBear> toRet = new ArrayList<>();
        for (AbstractAnimal animal : animals) {
            if (animal instanceof AbstractBear) {
                toRet.add((AbstractBear) animal);
            }
        }
        return toRet;
    }

    public ArrayList<AbstractLandAnimal> getLandAnimal() {
        ArrayList<AbstractLandAnimal> toRet = new ArrayList<>();
        for (AbstractAnimal animal : animals) {
            if (animal instanceof AbstractLandAnimal) {
                toRet.add((AbstractLandAnimal) animal);
            }
        }
        return toRet;
    }

    public ArrayList<AbstractMountainAnimal> getMountainAnimals() {
        ArrayList<AbstractMountainAnimal> toRet = new ArrayList<>();
        for (AbstractAnimal animal : animals) {
            if (animal instanceof AbstractMountainAnimal) {
                toRet.add((AbstractMountainAnimal) animal);
            }
        }
        return toRet;
    }

    public ArrayList<AbstractSeaAnimal> getSeaAnimals() {
        ArrayList<AbstractSeaAnimal> toRet = new ArrayList<>();
        for (AbstractAnimal animal : animals) {
            if (animal instanceof AbstractSeaAnimal) {
                toRet.add((AbstractSeaAnimal) animal);
            }
        }
        return toRet;
    }

    public ArrayList<AbstractTundraAnimal> getTundraAnimals() {
        ArrayList<AbstractTundraAnimal> toRet = new ArrayList<>();
        for (AbstractAnimal animal : animals) {
            if (animal instanceof AbstractTundraAnimal) {
                toRet.add((AbstractTundraAnimal) animal);
            }
        }
        return toRet;
    }

    public Integer getGridXMax() {
        return gridXMax;
    }

    public Integer getGridYMax() {
        return gridYMax;
    }

    public  ArrayList<AbstractNode> getGrid() {
        return grid;
    }

    @Override
    public Board clone() {
        return new Board(this.startBiome, this.gridXMax, this.gridYMax, this.startPopCap);
    }
}
