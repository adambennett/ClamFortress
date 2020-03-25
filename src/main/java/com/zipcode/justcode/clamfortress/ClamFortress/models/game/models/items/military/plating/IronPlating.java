package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.plating;

import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.armor.*;

public class IronPlating extends AbstractPlating {

    public IronPlating() {
        super("Bronze Plating", "Standard iron plate. Used to improve armor defense bonuses by 200.");
    }

    @Override
    public Integer modifyArmorDef(AbstractArmor armor) {
        return 200;
    }

    @Override
    public IronPlating clone() {
        return new IronPlating();
    }
}
