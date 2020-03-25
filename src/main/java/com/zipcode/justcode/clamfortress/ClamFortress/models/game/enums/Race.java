package com.zipcode.justcode.clamfortress.ClamFortress.models.game.enums;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

import java.util.*;
import java.util.concurrent.*;

public enum Race {
    HUMAN,
    ORC,
    ELF,
    DWARF,
    ALIEN,
    CLAMAN;

    public static Race getRandomRace() {
        ArrayList<Race> rands = new ArrayList<>();
        rands.add(Race.HUMAN);
        if (StatTracker.getAliensUnlocked()) {
            rands.add(Race.ALIEN);
        }

        if (StatTracker.getClamanUnlocked()) {
            rands.add(Race.CLAMAN);
        }

        if (StatTracker.getDwarvesUnlocked()) {
            rands.add(Race.DWARF);
        }

        if (StatTracker.getElvesUnlocked()) {
            rands.add(Race.ELF);
        }

        if (StatTracker.getOrcsUnlocked()) {
            rands.add(Race.ORC);
        }
        return rands.get(ThreadLocalRandom.current().nextInt(rands.size()));
    }

}
