package main.models.items.tools.hunting;

import main.models.items.tools.*;
import main.models.items.tools.gathering.*;

public class FishingRod extends AbstractFishingTool {
    public FishingRod() {
        super("Fishing Rod", "Improves Fishing.");
    }

    @Override
    public FishingRod clone() {
        return new FishingRod();
    }
}
