package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.tools.hunting;

public class HuntingSpear extends AbstractFishingTool {
    public HuntingSpear() {
        super("Hunting Spear", "Multiplies the food received from Hunting by 3x.");
    }

    @Override
    public HuntingSpear clone() {
        return new HuntingSpear();
    }

    @Override
    public Integer multiplyFoodOnHunting() { return 3; }
}