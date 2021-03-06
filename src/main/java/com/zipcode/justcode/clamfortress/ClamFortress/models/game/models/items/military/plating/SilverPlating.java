package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.plating;

import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.armor.*;

public class SilverPlating extends AbstractPlating {

    public SilverPlating() {
        super("Bronze Plating", "Fancy silver plating. Used to improve armor defense bonuses by 225.");
    }

    @Override
    public Integer modifyArmorDef(AbstractArmor armor) {
        return 100;
    }

    @Override
    public SilverPlating clone() {
        return new SilverPlating();
    }
}
