package main.models.nodes;

import main.models.nodes.biomes.*;

public class Desert extends AbstractNode {

    private Integer goldOre;
    private Integer ironOre;
    private Integer rocks;
    private Integer sand;

    public Desert(int xPos, int yPos, int goldOre, int ironOre, int rocks, int sand, AbstractBiome biome) {
        super(xPos, yPos, biome);
        this.goldOre = goldOre;
        this.ironOre = ironOre;
        this.rocks = rocks;
        this.sand = sand;
    }


    @Override
    public String toString() {
        return "Desert";
    }
}
