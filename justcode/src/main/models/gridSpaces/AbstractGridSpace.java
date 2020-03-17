package main.models.gridSpaces;

import main.game.logic.*;
import main.game.regions.*;
import main.models.artifacts.*;

import java.util.concurrent.*;

public abstract class AbstractGridSpace implements Comparable<AbstractGridSpace> {
    protected AbstractRegion biome;
    protected Integer xPos;
    protected Integer yPos;
    protected AbstractArtifact artifact;

    public AbstractGridSpace(int x, int y, AbstractRegion biome) {
        this.xPos = x;
        this.yPos = y;
        this.biome = biome;
        int artifactRoll = ThreadLocalRandom.current().nextInt(0, 500);
        if (artifactRoll == 1) {
            this.artifact = ArtifactManager.getRandomArtifact();
        }
    }

    public Boolean hasArtifact() {
        return artifact != null;
    }

    public AbstractArtifact getArtifact() {
        return artifact;
    }

    public void setArtifact(AbstractArtifact artifact) {
        this.artifact = artifact;
    }

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
