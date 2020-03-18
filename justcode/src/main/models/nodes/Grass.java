package main.models.nodes;

import main.models.*;
import main.models.animals.*;
import main.models.animals.land.*;
import main.models.nodes.biomes.*;
import main.models.resources.*;
import main.models.resources.natural.*;
import main.models.resources.refined.*;

import java.util.*;
import java.util.concurrent.*;

public class Grass extends AbstractNode {

    public Grass(int xPos, int yPos) {
        super(xPos, yPos, new Grasslands());
        ArrayList<AbstractLandAnimal> ar = Archive.getInstance().landAnimals();
        AbstractLandAnimal rand = ar.get(ThreadLocalRandom.current().nextInt(ar.size()));
        this.resources.put(new Wood(), ThreadLocalRandom.current().nextInt(1, 101));
        this.resources.put(new Lumber(), ThreadLocalRandom.current().nextInt(0, 11));
        this.resources.put(new Flowers(), ThreadLocalRandom.current().nextInt(0, 11));
        this.resources.put(new Seeds(), ThreadLocalRandom.current().nextInt(0, 6));
        this.resources.put(new Rock(), ThreadLocalRandom.current().nextInt(0, 6));
        this.resources.put(new Gems(), ThreadLocalRandom.current().nextInt(0, 2));
        this.animals.put(rand, ThreadLocalRandom.current().nextInt(1, 10));
    }

    @Override
    public String toString() {
        return "Grasslands";
    }
}
