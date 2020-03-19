package main.models.items.artifacts;

import main.interfaces.*;

public class RingOfForaging extends AbstractArtifact implements Unique {

    public RingOfForaging() {
        super("Ring of Foraging", "Increases your chances to find items and resources while Foraging.");
    }

    @Override
    public RingOfForaging clone() {
        return new RingOfForaging();
    }
}
