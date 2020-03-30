package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals.land.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes.biomes.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.other.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.refined.*;

import java.util.*;
import java.util.concurrent.*;

public class Grass extends AbstractNode {

    public Grass(int xPos, int yPos) {
        super(xPos, yPos, new Grasslands());
        ArrayList<AbstractLandAnimal> ar = Archive.getInstance().landAnimals();
        if (ar.size() > 0) {
            AbstractLandAnimal rand = ar.get(ThreadLocalRandom.current().nextInt(ar.size()));
            this.animals.put(rand, ThreadLocalRandom.current().nextInt(1, 10));
        }
        this.resources.put(new Wood(), ThreadLocalRandom.current().nextInt(1, 101));
        this.resources.put(new Lumber(), ThreadLocalRandom.current().nextInt(0, 11));
        this.resources.put(new Flowers(), ThreadLocalRandom.current().nextInt(0, 11));
        this.resources.put(new Seeds(), ThreadLocalRandom.current().nextInt(0, 6));
        this.resources.put(new Rock(), ThreadLocalRandom.current().nextInt(0, 6));
        this.resources.put(new Gems(), ThreadLocalRandom.current().nextInt(0, 2));

    }

    @Override
    public String toString() {
        return "Grasslands";
    }
}
