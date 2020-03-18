package main.models.nodes;

import main.models.*;
import main.models.animals.land.*;
import main.models.nodes.biomes.*;
import main.models.animals.sea.AbstractSeaAnimal;
import main.models.resources.natural.*;
import main.models.resources.refined.*;

import java.util.*;
import java.util.concurrent.*;

public class Sea extends AbstractNode {

    public Sea(int xPos, int yPos) {
        super(xPos, yPos, new Ocean());
        ArrayList<AbstractSeaAnimal> ar = Archive.getInstance().seaAnimals();
        AbstractSeaAnimal rand = ar.get(ThreadLocalRandom.current().nextInt(ar.size()));
        AbstractSeaAnimal randB = ar.get(ThreadLocalRandom.current().nextInt(ar.size()));
        AbstractSeaAnimal randC = ar.get(ThreadLocalRandom.current().nextInt(ar.size()));
        AbstractSeaAnimal randD = ar.get(ThreadLocalRandom.current().nextInt(ar.size()));
        this.resources.put(new Gems(), ThreadLocalRandom.current().nextInt(0, 11));
        this.resources.put(new Jewelery(), ThreadLocalRandom.current().nextInt(0, 6));
        this.resources.put(new Rock(), ThreadLocalRandom.current().nextInt(10, 101));
        this.resources.put(new Sand(), ThreadLocalRandom.current().nextInt(100, 1001));
        this.resources.put(new Clay(), ThreadLocalRandom.current().nextInt(0, 11));
        this.animals.put(rand, ThreadLocalRandom.current().nextInt(1, 100));
        this.animals.put(randB, ThreadLocalRandom.current().nextInt(1, 100));
        this.animals.put(randC, ThreadLocalRandom.current().nextInt(1, 100));
        this.animals.put(randD, ThreadLocalRandom.current().nextInt(1, 100));
    }

    @Override
    public String toString() {
        return "Ocean";
    }
}
