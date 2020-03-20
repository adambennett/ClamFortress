package main.models.items.tools.hunting;

import main.models.items.tools.*;

public class FishingSpear extends AbstractFishingTool {
    public FishingSpear() {
        super("Fishing Spear", "Improves Fishing.");
    }

    @Override
    public FishingSpear clone() {
        return new FishingSpear();
    }
}