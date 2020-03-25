package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals.mountain.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes.biomes.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.refined.*;

import java.util.*;
import java.util.concurrent.*;

public class Mountain extends AbstractNode {

    public Mountain(int xPos, int yPos) {
        super(xPos, yPos, new Mountainous());
        ArrayList<AbstractMountainAnimal> ar = Archive.getInstance().mountainAnimals();
        AbstractMountainAnimal rand = ar.get(ThreadLocalRandom.current().nextInt(ar.size()));
        this.resources.put(new Clay(), ThreadLocalRandom.current().nextInt(0, 101));
        this.resources.put(new Copper(), ThreadLocalRandom.current().nextInt(0, 101));
        this.resources.put(new Gems(), ThreadLocalRandom.current().nextInt(0, 11));
        this.resources.put(new Gold(), ThreadLocalRandom.current().nextInt(0, 16));
        this.resources.put(new Iron(), ThreadLocalRandom.current().nextInt(0, 1001));
        this.resources.put(new Rock(), ThreadLocalRandom.current().nextInt(100, 10001));
        this.resources.put(new Stone(), ThreadLocalRandom.current().nextInt(0, 26));
        this.animals.put(rand, ThreadLocalRandom.current().nextInt(0, 6));
    }

    @Override
    public String toString() {
        return "Mountain";
    }
}
