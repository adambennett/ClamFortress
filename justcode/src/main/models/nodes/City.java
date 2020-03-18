package main.models.nodes;

import main.enums.*;
import main.models.*;
import main.models.animals.land.*;
import main.models.nodes.biomes.*;
import main.models.people.Survivor;
import main.models.resources.*;
import main.models.resources.natural.*;
import main.models.resources.refined.*;
import main.utilities.*;
import main.utilities.builders.*;

import java.util.*;
import java.util.concurrent.*;

public class City extends AbstractNode {

    protected Integer cityDefense;
    protected ArrayList<Survivor> cityResidence;

    public City(int xPos, int yPos) {
        super(xPos, yPos, new Cityscape());
        this.cityResidence = new ArrayList<>();
        this.cityDefense = 10;
        setupCity();
    }

    protected void setupCity() {
        int pop = ThreadLocalRandom.current().nextInt(0, 1000);
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
            this.resources.put(rand, ThreadLocalRandom.current().nextInt(1, ThreadLocalRandom.current().nextInt(200, 10000)));
        }
    }

    public Integer getCityDefense(){
        return this.cityDefense;
    }

    public ArrayList<Survivor> getCityResidence(){
        return this.cityResidence;
    }

    @Override
    public String toString() {
        return "City";
    }


}
