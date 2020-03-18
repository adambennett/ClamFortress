package main.models.nodes;

import main.models.*;
import main.models.animals.tundra.*;
import main.models.nodes.biomes.*;

import java.util.*;
import java.util.concurrent.*;

public class Tundra extends AbstractNode {

    public Tundra(int xPos, int yPos) {
        super(xPos, yPos, new Icelands());
        ArrayList<AbstractTundraAnimal> ar = Archive.getInstance().tundraAnimals();
        AbstractTundraAnimal rand = ar.get(ThreadLocalRandom.current().nextInt(ar.size()));
        this.animals.put(rand, ThreadLocalRandom.current().nextInt(0, 3));
    }

    @Override
    public String toString() {
        return "Tundra";
    }
}
