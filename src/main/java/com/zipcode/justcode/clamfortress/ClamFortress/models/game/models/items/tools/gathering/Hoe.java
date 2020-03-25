package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.tools.gathering;

public class Hoe extends AbstractGatheringTool {
    public Hoe() {
        super("Hoe", "Used to improve Harvesting.");
    }

    @Override
    public Hoe clone() {
        return new Hoe();
    }
}
