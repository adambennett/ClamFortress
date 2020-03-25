package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.tools.hunting;

public class FishingRod extends AbstractFishingTool {
    public FishingRod() {
        super("Fishing Rod", "Improves Fishing.");
    }

    @Override
    public FishingRod clone() {
        return new FishingRod();
    }
}
