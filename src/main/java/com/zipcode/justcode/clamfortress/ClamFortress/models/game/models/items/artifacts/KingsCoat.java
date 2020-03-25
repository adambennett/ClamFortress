package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.artifacts;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;

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
