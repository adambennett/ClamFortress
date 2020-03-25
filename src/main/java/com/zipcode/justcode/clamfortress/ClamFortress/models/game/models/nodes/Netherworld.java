package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.beings.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.stringUtils.*;

import java.util.*;
import java.util.concurrent.*;

public class Netherworld extends City {

    public Netherworld(int xPos, int yPos) {
        super(xPos, yPos);
        this.cityDefense = 1000;
        this.hp = 100;
        this.maxHP = 100;
        this.uniqueName = GameStrings.getRandomName(true);
        setupCity();
    }

    @Override
    protected void setupCity() {
        int pop = ThreadLocalRandom.current().nextInt(100, 1000);
        for (int i = 0; i < pop; i++) {
            Survivor newCitizen = Archive.generateRandomSurvivor(false);
            this.cityResidence.add(newCitizen);
            this.cityDefense += newCitizen.getStrength();
            this.hp += newCitizen.getHP();
            this.maxHP += newCitizen.getMaxHp();
        }
        ArrayList<AbstractResource> res = Archive.getInstance().resources();
        Set<Integer> randIndices = new HashSet<>();
        while (randIndices.size() < 5 && res.size() > 5) {
            randIndices.add(ThreadLocalRandom.current().nextInt(res.size()));
        }
        ArrayList<Integer> ints = new ArrayList<>(randIndices);
        while (ints.size() > 0) {
            int index = ints.remove(0);
            AbstractResource rand = res.get(index);
            this.resources.put(rand, ThreadLocalRandom.current().nextInt(100, 1000));
        }
    }

    @Override
    public String toString() {
        return "Netherworld";
    }
}
