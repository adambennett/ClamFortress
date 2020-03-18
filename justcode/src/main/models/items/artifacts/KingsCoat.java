package main.models.items.artifacts;

import main.interfaces.*;
import main.models.items.*;

public class KingsCoat extends AbstractArtifact implements Unique {

    private static final Integer priorityBoost = 5;

    public KingsCoat() {
        super("King's Coat", "Increases the amount of priority points you receive each round.");
    }

    @Override
    public Integer modifyPriorityPoints() {
        return priorityBoost;
    }

    @Override
    public KingsCoat clone() {
        return new KingsCoat();
    }
}
