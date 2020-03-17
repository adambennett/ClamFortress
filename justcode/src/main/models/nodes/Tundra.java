package main.models.nodes;

import main.models.nodes.biomes.*;

public class Tundra extends AbstractNode {
    public Tundra(int x, int y, AbstractBiome biome) {
        super(x, y, biome);
    }


    @Override
    public String toString() {
        return "Tundra";
    }
}
