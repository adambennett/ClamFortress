package main.models.nodes;


import main.models.*;
import main.models.animals.jungle.*;
import main.models.animals.land.*;
import main.models.nodes.biomes.*;
import main.models.animals.*;
import main.models.resources.natural.*;

import java.util.*;
import java.util.concurrent.*;

public class Jungle extends AbstractNode {

    public Jungle(int xPos, int yPos) {
        super(xPos, yPos, new Forest());
        ArrayList<AbstractJungleAnimal> ar = Archive.getInstance().jungleAnimals();
        ArrayList<AbstractLandAnimal> arB = Archive.getInstance().landAnimals();
        AbstractJungleAnimal rand = ar.get(ThreadLocalRandom.current().nextInt(ar.size()));
        AbstractJungleAnimal randB = ar.get(ThreadLocalRandom.current().nextInt(ar.size()));
        AbstractLandAnimal randC = arB.get(ThreadLocalRandom.current().nextInt(ar.size()));
        this.resources.put(new Wood(), ThreadLocalRandom.current().nextInt(1000, 10001));
        this.resources.put(new Rock(), ThreadLocalRandom.current().nextInt(0, 21));
        this.resources.put(new Seeds(), ThreadLocalRandom.current().nextInt(100, 1001));
        this.resources.put(new Gems(), ThreadLocalRandom.current().nextInt(0, 101));
        this.animals.put(rand, ThreadLocalRandom.current().nextInt(1, 6));
        this.animals.put(randB, ThreadLocalRandom.current().nextInt(0, 5));
        this.animals.put(randC, ThreadLocalRandom.current().nextInt(0, 2));
    }

    @Override
    public String toString() {
        return "Jungle";
    }
}
