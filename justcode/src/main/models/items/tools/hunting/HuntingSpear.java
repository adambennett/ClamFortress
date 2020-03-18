package main.models.items.tools.hunting;

import main.models.items.tools.*;

public class HuntingSpear extends AbstractFishingTool {
    public HuntingSpear() {
        super("Hunting Spear", "");
    }

    @Override
    public HuntingSpear clone() {
        return new HuntingSpear();
    }
}