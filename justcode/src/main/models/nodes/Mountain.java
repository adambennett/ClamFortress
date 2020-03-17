package main.models.nodes;

import main.models.nodes.biomes.*;

public class Mountain extends AbstractNode {

    private Integer rocks;
    private Integer stone;
    private Integer ironOre;
    private Integer goldOre;
    private Integer copperOre;

    public Mountain(int xPos, int yPos, int rocks, int stone, int ironOre, int goldOre, int copperOre, AbstractBiome biome){
        super(xPos, yPos, biome);
        this.copperOre = copperOre;
        this.goldOre = goldOre;
        this.ironOre = ironOre;
        this.rocks = rocks;
        this.stone = stone;
    }
}
