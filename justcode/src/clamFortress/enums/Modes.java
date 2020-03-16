package clamFortress.enums;

import java.util.*;
import java.util.concurrent.*;

public enum Modes {
    EASY(1),
    DEFAULT(2),
    HARD(3),
    BRUTAL(4),
    NIGHTMARE(5),
    IMPOSSIBLE(6),
    CUSTOM(7),
    RANDOM(8);

    private final int value;

    Modes(int val) {
        this.value = val;
    }

    public static Modes getRandomMode() {
        ArrayList<Modes> rands = new ArrayList<>();
        rands.add(Modes.IMPOSSIBLE);
        rands.add(Modes.EASY);
        rands.add(Modes.HARD);
        rands.add(Modes.DEFAULT);
        rands.add(Modes.BRUTAL);
        rands.add(Modes.NIGHTMARE);
        return rands.get(ThreadLocalRandom.current().nextInt(rands.size()));
    }
}
