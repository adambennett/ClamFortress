package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals.tundra.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes.biomes.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.other.*;

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
