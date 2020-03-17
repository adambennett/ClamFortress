package main.models.managers;


import main.encounters.*;
import main.encounters.plagues.*;
import java.util.*;


public class EncounterManager {

    private static Random rng;

    static {
        rng = new Random();
    }

    public static ArrayList<AbstractEncounter> generateEncounters() {
        return generateEncounters(rng.nextInt(101));
    }

    public static ArrayList<AbstractEncounter> generateEncounters(int roll) {
        ArrayList<AbstractEncounter> currentEncounters = new ArrayList<>();
        if (roll == 43) {
            currentEncounters.add(new Bubonic());
        }
        return currentEncounters;
    }

    public static void setSeed(int val) {
        rng.setSeed(val);
    }
}
