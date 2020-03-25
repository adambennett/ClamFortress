package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals.desert.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes.biomes.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural.*;

import java.util.*;
import java.util.concurrent.*;

public class Desert extends AbstractNode {

    public Desert(int xPos, int yPos) {
        super(xPos, yPos, new DesertBiome());
        ArrayList<AbstractDesertAnimal> ar = Archive.getInstance().desertAnimals();
        AbstractDesertAnimal rand = ar.get(ThreadLocalRandom.current().nextInt(ar.size()));
        AbstractDesertAnimal randB = ar.get(ThreadLocalRandom.current().nextInt(ar.size()));
        AbstractDesertAnimal randC = ar.get(ThreadLocalRandom.current().nextInt(ar.size()));
        this.resources.put(new Clay(), ThreadLocalRandom.current().nextInt(1, 11));
        this.resources.put(new Rock(), ThreadLocalRandom.current().nextInt(1, 11));
        this.resources.put(new Sand(), ThreadLocalRandom.current().nextInt(1000, 10001));
        this.animals.put(rand, ThreadLocalRandom.current().nextInt(1, 11));
        this.animals.put(randB, ThreadLocalRandom.current().nextInt(1, 11));
        this.animals.put(randC, ThreadLocalRandom.current().nextInt(1, 11));
    }


    @Override
    public String toString() {
        return "Desert";
    }
}
