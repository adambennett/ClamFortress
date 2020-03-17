package main.models.nodes;


import main.models.*;
import main.models.nodes.biomes.*;
import main.models.animals.*;
import main.models.resources.natural.Flowers;

import java.util.*;

public class Jungle extends AbstractNode {

    private Integer trees;
    private Integer rocks;
    private ArrayList<Flowers> flowers;
    private ArrayList<Animal> animals;

    public Jungle(int xPos, int yPos, int trees, int rocks, AbstractBiome biome) {
        super(xPos, yPos, biome);
        this.trees = trees;
        this.rocks = rocks;
        this.flowers = Game.generateRandomFlowers(biome);
        this.animals = Game.generateRandomAnimals(biome);
    }

    public ArrayList<Flowers> getFlowers() {
        return flowers;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }


    @Override
    public String toString() {
        return "Jungle";
    }
}
