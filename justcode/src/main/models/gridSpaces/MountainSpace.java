package main.models.gridSpaces;

public class MountainSpace extends AbstractGridSpace {

    private Integer rocks;
    private Integer stone;
    private Integer ironOre;
    private Integer goldOre;
    private Integer copperOre;


    public MountainSpace(int xPos, int yPos,int rocks, int ston,int ironOre, int goldOre,int copperOre){
        this.xPos = xPos;
        this.yPos = yPos;
        this.copperOre = copperOre;
        this.goldOre = goldOre;
        this.ironOre = ironOre;
        this.rocks = rocks;
        this.stone = stone;
    }


    public Integer getRocks() {
        return rocks;
    }

    public Integer getStone() {
        return stone;
    }

    public Integer getIronOre() {
        return ironOre;
    }

    public Integer getGoldOre() {
        return goldOre;
    }

    public Integer getCopperOre() {
        return copperOre;
    }
}
