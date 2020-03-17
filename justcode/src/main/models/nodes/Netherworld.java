package main.models.nodes;

import main.models.nodes.biomes.*;
import main.models.people.*;

import java.util.*;

public class Netherworld extends City {

    public Netherworld(int x, int y, AbstractBiome biome, Integer cityDefense, ArrayList<Survivor> cityResidence) {
        super(x, y, biome, cityDefense, cityResidence);
    }

    @Override
    public String toString() {
        return "Netherworld";
    }
}
