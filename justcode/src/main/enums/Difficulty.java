package main.enums;

import java.util.*;
import java.util.concurrent.*;

public enum Difficulty {
    EASY(1, 6),
    DEFAULT(2, 5),
    HARD(3, 4),
    BRUTAL(4, 3),
    NIGHTMARE(5, 2),
    IMPOSSIBLE(6, 1),
    CUSTOM(7, 5),
    RANDOM(8, 5);

    private final int value;
    private final int priorityMod;

    Difficulty(int val, int priorityMod) {
        this.value = val;
        this.priorityMod = priorityMod;
    }

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
