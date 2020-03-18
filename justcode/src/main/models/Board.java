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
import main.models.nodes.AbstractNode;
import main.models.nodes.Grass;
import main.models.nodes.Village;
import main.models.nodes.biomes.AbstractBiome;
import main.models.nodes.biomes.Grasslands;
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

    private final AbstractBiome startBiome;
    private Village village;
    private ArrayList<AbstractNode> grid;
    private ArrayList<AbstractAnimal> animals;
    private Map<AbstractResource, Integer> resources;

    public Board(AbstractBiome startingBiome, int xMax, int yMax) {
        super("Game Board");
        this.village = new Village(startingBiome);
        this.village.setxPos(0);
        this.village.setyPos(0);
        this.gridXMax = xMax;
        this.gridYMax = yMax;
        this.grid = new ArrayList<>();
        this.grid.add(this.village);
        this.animals = new ArrayList<>();
        this.resources = new HashMap<>();
        this.startBiome = startingBiome;
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
        return NodeManager.getRandomNode(x, y);
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
            for (GameObject obj : Game.getModifierObjects()) {
                obj.onDiscoverNewRegion(space);
            }
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

    public void addAnimals(AbstractAnimal animal, int amt) {
        for (int i = 0; i < amt; i++) {
            animals.add(animal.clone());
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

    @Override
    public Board clone() {
        return new Board(this.startBiome, this.gridXMax, this.gridYMax);
    }
}
