package main.models.gridSpaces;


import main.game.*;
import main.game.regions.*;
import main.models.animals.*;
import main.models.animals.jungle.JungleAnimal;
import main.models.resources.natural.Flowers;

import java.util.*;

public class JungleSpace extends AbstractGridSpace {

    private Integer trees;
    private Integer rocks;
    private ArrayList<Flowers> flowers;
    private ArrayList<Animal> animals;

    public JungleSpace(int xPos, int yPos, int trees, int rocks, AbstractRegion biome) {
        super(xPos, yPos, biome);
        this.trees = trees;
        this.rocks = rocks;
        this.flowers = Game.generateRandomFlowers(biome);
        this.animals = Game.generateRandomAnimals(biome);
    }

    public Integer getTrees() {
        return trees;
    }

    public Integer getRocks() {
        return rocks;
    }

    public ArrayList<Flowers> getFlowers() {
        return flowers;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }
}
