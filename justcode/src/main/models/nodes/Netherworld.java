package main.models.nodes;

import main.models.*;
import main.models.nodes.biomes.*;
import main.models.people.*;
import main.models.resources.*;

import java.util.*;
import java.util.concurrent.*;

public class Netherworld extends City {

    public Netherworld(int xPos, int yPos) {
        super(xPos, yPos);
        this.cityDefense = 1000;
    }

    @Override
    protected void setupCity() {
        int pop = ThreadLocalRandom.current().nextInt(1000, 10000);
        for (int i = 0; i < pop; i++) {
            Survivor newCitizen = Archive.generateRandomSurvivor();
            this.cityResidence.add(newCitizen);
            this.cityDefense += newCitizen.getStrength();
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
            this.resources.put(rand, ThreadLocalRandom.current().nextInt(10000, 100000));
        }
    }

    @Override
    public String toString() {
        return "Netherworld";
    }
}
