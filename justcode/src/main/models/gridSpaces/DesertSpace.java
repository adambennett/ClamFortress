package main.models.gridSpaces;

import main.game.regions.*;

import java.util.ArrayList;

public class DesertSpace extends AbstractGridSpace {

    private Integer goldOre;
    private Integer ironOre;
    private Integer rocks;
    private Integer sand;

    public DesertSpace(int xPos, int yPos, int goldOre, int ironOre, int rocks, int sand, AbstractRegion biome) {
        super(xPos, yPos, biome);
        this.goldOre = goldOre;
        this.ironOre = ironOre;
        this.rocks = rocks;
        this.sand = sand;
    }

    public Integer getRocks() {
        return rocks;
    }

    public Integer getgoldOre() {
        return goldOre;
    }

    public Integer getIronOre() {
        return ironOre;
    }

    public Integer getSand(){return this.sand;}

}
