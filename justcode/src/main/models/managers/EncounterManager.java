package main.models.managers;


import main.encounters.*;
import main.encounters.alien.*;
import main.encounters.disasters.*;
import main.encounters.merchant.*;
import main.encounters.miracles.*;
import main.encounters.plagues.*;

import java.util.*;
import java.util.concurrent.*;


public class EncounterManager {

    private static Random rng;

    static {
        rng = new Random();
    }

    public static AbstractEncounter getRandomEncounter() {
        ArrayList<AbstractEncounter> encounters = new ArrayList<>();
        encounters.add(new AlienInvasion());
        encounters.add(new FriendlyAliens());
        encounters.add(new NeutralAlien());
        encounters.add(new Earthquake());
        encounters.add(new Fire());
        encounters.add(new Flood());
        encounters.add(new Hurricane());
        encounters.add(new Tornado());
        encounters.add(new Tsunami());
        encounters.add(new Typhoon());
        encounters.add(new Volcano());
        encounters.add(new ArtifactMerchant());
        encounters.add(new Blessing());
        encounters.add(new DivineHealing());
        encounters.add(new DivineIntervention());
        encounters.add(new Wisdom());
        encounters.add(new Bubonic());
        encounters.add(new Contagion());
        encounters.add(new COVID19());
        encounters.add(new H1N1());
        encounters.add(new Pandemic());
        encounters.add(new SARS());
        encounters.add(new SpanishFlu());
        return encounters.get(ThreadLocalRandom.current().nextInt(encounters.size()));
    }

    public static ArrayList<AbstractEncounter> generateEncounters() {
        return generateEncounters(rng.nextInt(101));
    }

    public static ArrayList<AbstractEncounter> generateEncounters(int roll) {
        ArrayList<AbstractEncounter> currentEncounters = new ArrayList<>();
        //if (roll == 43) {
            currentEncounters.add(getRandomEncounter());
        //}
        return currentEncounters;
    }

    public static void setSeed(int val) {
        rng.setSeed(val);
    }
}
