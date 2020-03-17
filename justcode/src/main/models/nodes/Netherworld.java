package main.models.nodes;

import main.models.nodes.biomes.*;

public class Netherworld extends City {

    public Netherworld(int x, int y, AbstractBiome biome) {
        super(x, y, biome);
    }


    @Override
    public String toString() {
        return "Netherworld";
    }
}
