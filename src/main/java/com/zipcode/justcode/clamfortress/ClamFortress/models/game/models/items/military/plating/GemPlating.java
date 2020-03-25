package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.plating;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.armor.*;

public class GemPlating extends AbstractPlating {

    public GemPlating() {
        super("Gem Plating", "Amazing armor plating crafted from rare gems. Improve armor defense bonuses by 325.");
    }

    @Override
    public Integer modifyArmorDef(AbstractArmor armor) {
        return 325;
    }

    @Override
    public GemPlating clone() {
        return new GemPlating();
    }
}
