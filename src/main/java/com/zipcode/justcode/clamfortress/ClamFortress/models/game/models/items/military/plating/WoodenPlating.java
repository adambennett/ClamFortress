package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.plating;

import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.armor.*;

public class WoodenPlating extends AbstractPlating {

    public WoodenPlating() {
        super("Bronze Plating", "Cheap wooden armor plates. Used to improve armor defense bonuses by 25.");
    }

    @Override
    public Integer modifyArmorDef(AbstractArmor armor) {
        return 25;
    }

    @Override
    public WoodenPlating clone() {
        return new WoodenPlating();
    }
}
