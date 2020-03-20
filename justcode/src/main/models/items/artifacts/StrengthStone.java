package main.models.items.artifacts;

import main.interfaces.*;
import main.models.people.*;

public class StrengthStone extends AbstractArtifact implements Unique {

    private static final Integer strBoost = 10;

    public StrengthStone() {
        super("Strength Stone", "Whenever a new villager moves in, they gain 10 Strength.");
    }

    @Override
    public Survivor onNewCitizen(Survivor newCitizen) {
        newCitizen.setStrength(newCitizen.getStrength() + strBoost);
        return newCitizen;
    }

    @Override
    public StrengthStone clone() {
        return new StrengthStone();
    }
}
