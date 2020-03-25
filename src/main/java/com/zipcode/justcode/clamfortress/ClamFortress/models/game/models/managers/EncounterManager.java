package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.alien.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.disasters.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.miracles.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.plagues.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;

import java.util.*;
import java.util.concurrent.*;

public class EncounterManager {

    private static Random rng;

    static {
        rng = new Random();
    }

    public static AbstractEncounter getRandomEncounter() {
        ArrayList<AbstractEncounter> encounters = new ArrayList<>();
        int tempVal = 10;
        encounters.add(new AlienInvasion(tempVal, tempVal));
        encounters.add(new FriendlyAliens(tempVal));
        encounters.add(new NeutralAlien(tempVal));
        encounters.add(new Earthquake());
        encounters.add(new Fire(tempVal));
        encounters.add(new Flood(tempVal));
        encounters.add(new Hurricane(tempVal));
        encounters.add(new Tornado(tempVal));
        encounters.add(new Tsunami());
        encounters.add(new Typhoon(tempVal));
        encounters.add(new Volcano());
        encounters.add(new ClericBlessing(tempVal));
        encounters.add(new DivineHealing(tempVal));
        encounters.add(new Bubonic(tempVal));
        encounters.add(new Contagion(tempVal));
        encounters.add(new COVID19(tempVal));
        encounters.add(new H1N1(tempVal));
        encounters.add(new Pandemic(tempVal));
        encounters.add(new SARS(tempVal));
        encounters.add(new SpanishFlu(tempVal));
        if (!Game.getVillage().getInventory().containsItem("Rabbit's Foot")) {
            encounters.add(new AlienInvasion(tempVal,tempVal));
            encounters.add(new Earthquake());
            encounters.add(new Fire(tempVal));
            encounters.add(new Flood(tempVal));
            encounters.add(new Hurricane(tempVal));
            encounters.add(new Tornado(tempVal));
            encounters.add(new Tsunami());
            encounters.add(new Typhoon(tempVal));
            encounters.add(new Volcano());
            encounters.add(new Bubonic(tempVal));
            encounters.add(new Contagion(tempVal));
            encounters.add(new COVID19(tempVal));
            encounters.add(new H1N1(tempVal));
            encounters.add(new Pandemic(tempVal));
            encounters.add(new SARS(tempVal));
            encounters.add(new SpanishFlu(tempVal));
            encounters.add(new AlienInvasion(tempVal, tempVal));
            encounters.add(new Earthquake());
            encounters.add(new Fire(tempVal));
            encounters.add(new Flood(tempVal));
            encounters.add(new Hurricane(tempVal));
            encounters.add(new Tornado(tempVal));
            encounters.add(new Tsunami());
            encounters.add(new Typhoon(tempVal));
            encounters.add(new Volcano());
            encounters.add(new Bubonic(tempVal));
            encounters.add(new Contagion(tempVal));
            encounters.add(new COVID19(tempVal));
            encounters.add(new H1N1(tempVal));
            encounters.add(new Pandemic(tempVal));
            encounters.add(new SARS(tempVal));
            encounters.add(new SpanishFlu(tempVal));
        } else {
            encounters.add(new ClericBlessing(tempVal));
            encounters.add(new DivineHealing(tempVal));
            encounters.add(new ClericBlessing(tempVal));
            encounters.add(new DivineHealing(tempVal));
        }

        return encounters.get(ThreadLocalRandom.current().nextInt(encounters.size()));
    }

    public static ArrayList<AbstractEncounter> generateEncounters() {
        return generateEncounters(rng.nextInt(101));
    }

    public static ArrayList<AbstractEncounter> generateEncounters(int roll) {
        ArrayList<AbstractEncounter> currentEncounters = new ArrayList<>();
        if (roll == 43) {
            currentEncounters.add(getRandomEncounter());
        }
        return currentEncounters;
    }

    public static void setSeed(int val) {
        rng.setSeed(val);
    }
}
