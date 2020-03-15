package clamFortress.encounters;

import clamFortress.encounters.alien.*;
import clamFortress.encounters.disasters.*;
import clamFortress.encounters.miracles.*;
import clamFortress.encounters.plagues.*;

import java.util.*;
import java.util.concurrent.*;

public class EncounterManager {

    public static void runEncounters() {
        ArrayList<AbstractEncounter> encounters = generateEncounters();
        for (AbstractEncounter enc : encounters) {
            enc.runEncounter();
        }
    }

    public static ArrayList<AbstractEncounter> generateEncounters() {
        return generateEncounters(ThreadLocalRandom.current().nextInt(0, 1001));
    }

    public static ArrayList<AbstractEncounter> generateEncounters(int roll) {

        ArrayList<AbstractEncounter> currentEncounters = new ArrayList<>();

// BAD STUFF------------------------------------------------------------------------------------------------------------
        if (roll == 10) {
            currentEncounters.add(new Bubonic());
        }

        if (roll == 26) {
            currentEncounters.add(new Volcano());
        }

        if (roll == 29 || roll == 602) {
            currentEncounters.add(new Flood());
        }

        if (roll == 66) {
            currentEncounters.add(new AlienInvasion());
            currentEncounters.add(new Earthquake());
        }

        if (roll == 67) {
            currentEncounters.add(new AlienInvasion());
            currentEncounters.add(new Fire());
        }

        if (roll == 50) {
            currentEncounters.add(new Bubonic());
        }


        if (roll > 80 && roll < 155) {
            currentEncounters.add(new Bubonic());
            currentEncounters.add(new Fire());
        }

        if (roll > 160 && roll < 275 && roll != 200) {
            currentEncounters.add(new H1N1());
        }
// END BAD STUFF--------------------------------------------------------------------------------------------------------


// GOOD STUFF-----------------------------------------------------------------------------------------------------------
        if (roll == 75 || roll > 99 && roll < 123) {
            currentEncounters.add(new Blessing());
            if (roll == 103) {
                currentEncounters.add(new Blessing());
            }
        }

        if (roll == 679) {
            currentEncounters.add(new FriendlyAliens());
        }

        if (roll == 680) {
            currentEncounters.add(new Wisdom());
            currentEncounters.add(new NeutralAlien());
        }

        if (roll > 500) {
            currentEncounters.add(new NeutralAlien());
        }

        if (roll > 500 & roll < 525) {
            currentEncounters.add(new Bubonic());
        }
// END GOOD STUFF-------------------------------------------------------------------------------------------------------


        return currentEncounters;
    }
}
