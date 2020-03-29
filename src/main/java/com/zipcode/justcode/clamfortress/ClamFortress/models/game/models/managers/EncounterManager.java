package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.alien.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.disasters.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.miracles.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.plagues.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

import java.util.*;
import java.util.concurrent.*;

public class EncounterManager {

    private static Random rng;

    static {
        rng = new Random();
    }

    public static AbstractEncounter getRandomEncounter() {
        ArrayList<AbstractEncounter> encounters = Archive.getInstance().encounters();
        int turnTimer = ThreadLocalRandom.current().nextInt(1, 8);
        AbstractEncounter output = encounters.get(ThreadLocalRandom.current().nextInt(encounters.size()));
        boolean badEnc = output instanceof AbstractDisaster || output instanceof AbstractPlague;
        if (badEnc && Database.getCurrentGame().getGameBoard().getVillage().getInventory().containsItem("Rabbit's Foot")) {
            turnTimer -= 3;
        }
        if (turnTimer < 0) {
           turnTimer = 0;
        }
        output.setTurnsActive(turnTimer);
        return encounters.get(ThreadLocalRandom.current().nextInt(encounters.size()));
    }

    public static ArrayList<AbstractEncounter> generateEncounters() {
        return generateEncounters(rng.nextInt(101));
    }

    public static ArrayList<AbstractEncounter> generateEncounters(int roll) {
        ArrayList<AbstractEncounter> currentEncounters = new ArrayList<>();
        if (roll == 43) {
            AbstractEncounter rand = getRandomEncounter();
            if (rand.getTurnsActive() > 0) {
                currentEncounters.add(rand);
            }
        }
        return currentEncounters;
    }

    public static void setSeed(int val) {
        rng.setSeed(val);
    }
}
