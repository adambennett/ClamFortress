package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.tools.hunting;

public class FishingSpear extends AbstractFishingTool {
    public FishingSpear() {
        super("Fishing Spear", "Improves Fishing.");
    }

    @Override
    public FishingSpear clone() {
        return new FishingSpear();
    }
}