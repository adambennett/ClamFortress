package main.enums;

import java.util.*;
import java.util.concurrent.*;

public enum Difficulty {
    EASY(1, 6, 2),
    DEFAULT(2, 5, 1),
    HARD(3, 4, 0),
    BRUTAL(4, 3, -1),
    NIGHTMARE(5, 2, -2),
    IMPOSSIBLE(6, 1, -3),
    CUSTOM(7, 5, 0),
    RANDOM(8, 5, 0);

    private final int value;
    private final int priorityMod;
    private final int nethermod;

    Difficulty(int val, int priorityMod, int nethermod) {
        this.value = val;
        this.priorityMod = priorityMod;
        this.nethermod = nethermod;
    }

    public int getNethermod() {
        return nethermod;
    }

    public int getValue() { return value; }

    public int getPriorityMod() {
        return priorityMod;
    }

    public static Difficulty getRandomDifficulty() {
        ArrayList<Difficulty> rands = new ArrayList<>();
        rands.add(Difficulty.IMPOSSIBLE);
        rands.add(Difficulty.EASY);
        rands.add(Difficulty.HARD);
        rands.add(Difficulty.DEFAULT);
        rands.add(Difficulty.BRUTAL);
        rands.add(Difficulty.NIGHTMARE);
        return rands.get(ThreadLocalRandom.current().nextInt(rands.size()));
    }
}
