package main.enums;

import java.util.*;

public enum FoodOptions {
    HUNTING(Race.HUMAN),
    FISHING(Race.HUMAN),
    COOKING(Race.HUMAN),
    RAIDING(Race.ORC),
    SACRIFICE(Race.ORC),
    HUNTING_ORC(Race.ORC),
    SCAVENGE(Race.DWARF);

    private final Race associatedRace;

    FoodOptions(Race associatedRace) {
        this.associatedRace = associatedRace;
    }

    public String writeInConsole() {
        if (this.equals(HUNTING) || this.equals(HUNTING_ORC)) {
            return "HUNTING";
        } else {
            return this.toString();
        }
    }

    public static ArrayList<FoodOptions> getOptionsFromRace(Race race) {
        ArrayList<FoodOptions> foods = new ArrayList<>();
        for (FoodOptions f : FoodOptions.values()) {
            if (f.associatedRace.equals(race)) {
                foods.add(f);
            }
        }
        return foods;
    }

}
