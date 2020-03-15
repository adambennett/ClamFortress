package clamFortress.enums;

import clamFortress.utilities.persistence.*;

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
        if (Database.getAliensUnlocked()) {
            rands.add(Race.ALIEN);
        }

        if (Database.getClamanUnlocked()) {
            rands.add(Race.CLAMAN);
        }

        if (Database.getDwarvesUnlocked()) {
            rands.add(Race.DWARF);
        }

        if (Database.getElvesUnlocked()) {
            rands.add(Race.ELF);
        }

        if (Database.getOrcsUnlocked()) {
            rands.add(Race.ORC);
        }
        return rands.get(ThreadLocalRandom.current().nextInt(rands.size()));
    }

}
