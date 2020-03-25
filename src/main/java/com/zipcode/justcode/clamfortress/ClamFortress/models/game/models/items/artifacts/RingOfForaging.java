package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.artifacts;

import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;

public class RingOfForaging extends AbstractArtifact implements Unique {

    public RingOfForaging() {
        super("Ring of Foraging", "Increases your chances to find items and resources while Foraging.");
    }

    @Override
    public RingOfForaging clone() {
        return new RingOfForaging();
    }
}
