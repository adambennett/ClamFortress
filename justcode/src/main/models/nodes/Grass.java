package main.models.nodes;

import main.models.*;
import main.models.nodes.biomes.*;
import main.models.resources.natural.*;

import java.util.*;

public class Grass extends AbstractNode {

    private Integer trees;
    private Integer stones;
    private Integer rocks;
    private ArrayList<Flowers> flowers;

    public Grass(int xPos, int yPos, int trees, int stones, int rocks, AbstractBiome biome) {
        super(xPos, yPos, biome);
        this.trees = trees;
        this.stones = stones;
        this.rocks = rocks;
        this.flowers = Game.generateRandomFlowers(biome);
    }

    public Integer getRocks() {
        return rocks;
    }

    public Integer getTrees() {
        return trees;
    }

    public Integer getStones() {
        return stones;
    }

    public ArrayList<Flowers> getFlowers() {
        return flowers;
    }
}
