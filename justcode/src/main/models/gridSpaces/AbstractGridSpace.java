package main.models.gridSpaces;

import main.game.regions.*;

public abstract class AbstractGridSpace implements Comparable<AbstractGridSpace> {
    protected AbstractRegion biome;
    protected Integer xPos;
    protected Integer yPos;

    public AbstractRegion getBiome() {
        return biome;
    }

    public Integer getxPos() {
        return xPos;
    }

    public void setxPos(Integer xPos) {
        this.xPos = xPos;
    }

    public Integer getyPos() {
        return yPos;
    }

    public void setyPos(Integer yPos) {
        this.yPos = yPos;
    }

    @Override
    public int compareTo(AbstractGridSpace a) {
        return a.xPos.compareTo(this.xPos);
    }
}
