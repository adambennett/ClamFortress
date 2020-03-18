package main.models.nodes;

import main.models.nodes.biomes.*;
import main.models.items.artifacts.*;
import main.models.managers.*;

import java.util.concurrent.*;

public abstract class AbstractNode implements Comparable<AbstractNode> {
    protected AbstractBiome biome;
    protected Integer xPos;
    protected Integer yPos;
    protected AbstractArtifact artifact;

    public AbstractNode(int x, int y, AbstractBiome biome) {
        this.xPos = x;
        this.yPos = y;
        this.biome = biome;
       // int artifactRoll = ThreadLocalRandom.current().nextInt(0, 500);
        int artifactRoll = 1;
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

    public void setArtifact(AbstractArtifact art) {
        this.artifact = art;
    }

    public AbstractBiome getBiome() {
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
    public int compareTo(AbstractNode a) {
        return a.xPos.compareTo(this.xPos);
    }

    @Override
    public abstract String toString();
}
