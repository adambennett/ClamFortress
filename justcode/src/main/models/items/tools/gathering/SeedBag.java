package main.models.items.tools.gathering;

import main.models.items.tools.*;

public class SeedBag extends AbstractGatheringTool {
    public SeedBag() {
        super("Seed Bag", "");
    }


    @Override
    public SeedBag clone() {
        return new SeedBag();
    }
}
