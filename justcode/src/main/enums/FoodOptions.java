package main.enums;

import java.util.*;

public enum FoodOptions {
    HUNTING(Race.HUMAN),
    FISHING(Race.HUMAN),
    COOKING(Race.HUMAN),
    RAIDING(Race.ORC),
    HUNTING_ORC(Race.ORC),
    SACRIFICE(Race.ORC),
    INSECT_HUNTING(Race.ELF),
    RIVER_SEARCH(Race.ELF),
    ROASTING(Race.ELF),
    BREW(Race.DWARF),
    MUSHROOM_PICK(Race.DWARF),
    SCAVENGE(Race.DWARF),
    ANGLING(Race.CLAMAN),
    DIVING(Race.CLAMAN),
    TRAWL(Race.CLAMAN),
    ABDUCT(Race.ALIEN),
    ANALYZE(Race.ALIEN),
    REDACTED(Race.ALIEN);

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
