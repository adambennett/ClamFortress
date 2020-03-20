package main.models.items.tools.gathering;

import main.models.items.tools.*;

public class Hoe extends AbstractGatheringTool {
    public Hoe() {
        super("Hoe", "Used to improve Harvesting.");
    }

    @Override
    public Hoe clone() {
        return new Hoe();
    }
}
