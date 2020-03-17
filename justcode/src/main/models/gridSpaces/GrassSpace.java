package main.models.gridSpaces;

import main.game.*;
import main.game.regions.*;
import main.models.resources.natural.*;

import java.util.*;

public class GrassSpace extends AbstractGridSpace {

    private Integer trees;
    private Integer stones;
    private Integer rocks;
    private ArrayList<Flowers> flowers;

    public GrassSpace(int xPos, int yPos, int trees, int stones, int rocks, AbstractRegion biome) {
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
