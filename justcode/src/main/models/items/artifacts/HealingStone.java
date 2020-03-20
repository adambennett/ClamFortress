package main.models.items.artifacts;

import main.interfaces.*;
import main.models.people.*;

public class HealingStone extends AbstractArtifact implements Unique {

    private static final Integer maxHPBoost = 10;

    public HealingStone() {
        super("Healing Stone", "Whenever a new villager moves in, they gain 10 Max HP.");
    }

    @Override
    public Survivor onNewCitizen(Survivor newCitizen) {
        newCitizen.setMaxHp(newCitizen.getMaxHp() + maxHPBoost);
        newCitizen.setHealthPoints(newCitizen.getHP() + maxHPBoost);
        return newCitizen;
    }

    @Override
    public HealingStone clone() {
        return new HealingStone();
    }
}
