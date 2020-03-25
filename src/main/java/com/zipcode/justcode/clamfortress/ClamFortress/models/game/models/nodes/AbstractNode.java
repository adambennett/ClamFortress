package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.artifacts.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes.biomes.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.*;

import java.util.*;
import java.util.concurrent.*;

public abstract class AbstractNode implements Comparable<AbstractNode> {
    protected AbstractBiome biome;
    protected Integer xPos;
    protected Integer yPos;
    protected AbstractArtifact artifact;
    protected AbstractItem item;
    protected Map<AbstractResource, Integer> resources;
    protected Map<AbstractAnimal, Integer> animals;

    public AbstractNode(int x, int y, AbstractBiome biome) {
        this.xPos = x;
        this.yPos = y;
        this.biome = biome;
        this.resources = new HashMap<>();
        this.animals = new HashMap<>();
        int artifactRoll = ThreadLocalRandom.current().nextInt(0, 50);
        if (artifactRoll == 1) {
            this.artifact = ArtifactManager.getRandomArtifact();
        }
        int itemRoll = ThreadLocalRandom.current().nextInt(0, 10);
        if (itemRoll == 1) {
            this.item = ItemManager.getRandomItem();
        }
    }

    public AbstractNode() {}

    public Boolean hasArtifact() {
        return artifact != null;
    }

    public Boolean hasItem() {
        return item != null;
    }

    public AbstractArtifact getArtifact() {
        return artifact;
    }

    public AbstractItem getItem() { return item; }

    public AbstractBiome getBiome() {
        return biome;
    }

    public Integer getxPos() {
        return xPos;
    }

    public Integer getyPos() {
        return yPos;
    }

    public Map<AbstractResource, Integer> getResources() {
        return resources;
    }

    public Map<AbstractAnimal, Integer> getAnimals() {
        return animals;
    }

    public void setArtifact(AbstractArtifact artifact) {
        this.artifact = artifact;
    }

    public void setItem(AbstractItem item) {
        this.item = item;
    }

    @Override
    public int compareTo(AbstractNode a) {
        return (a.xPos.compareTo(this.xPos) != 0) ? a.xPos.compareTo(this.xPos) : a.yPos.compareTo(this.yPos);
    }

    public String getIcon() {
        return "";
    }

    @Override
    public abstract String toString();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractNode)) return false;
        AbstractNode that = (AbstractNode) o;
        return Objects.equals(getxPos(), that.getxPos()) &&
                Objects.equals(getyPos(), that.getyPos()) &&
                Objects.equals(getClass().getSimpleName(), that.getClass().getSimpleName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getxPos(), getyPos(), getClass().getSimpleName());
    }
}
