package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.tools.gathering;

public class SeedBag extends AbstractGatheringTool {
    public SeedBag() {
        super("Seed Bag", "Allows you to plant more seeds.");
    }


    @Override
    public SeedBag clone() {
        return new SeedBag();
    }
}
