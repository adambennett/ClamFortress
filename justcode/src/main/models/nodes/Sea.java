package main.models.nodes;

import main.models.*;
import main.models.nodes.biomes.*;
import main.models.animals.sea.SeaAnimal;

import java.util.*;

public class Sea extends AbstractNode {

    private ArrayList<SeaAnimal> seaLife;

    public Sea(int x, int y, AbstractBiome biome) {
        super(x, y, biome);
        this.seaLife = Game.generateRandomAquatic();
    }


    @Override
    public String toString() {
        return "Ocean";
    }
}
