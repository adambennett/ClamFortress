package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.plating;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.armor.*;

public class BronzePlating extends AbstractPlating {

    public BronzePlating() {
        super("Bronze Plating", "Simple bronze plate. Used to improve armor defense bonuses by 100.");
    }

    @Override
    public Integer modifyArmorDef(AbstractArmor armor) {
        return 100;
    }

    @Override
    public BronzePlating clone() {
        return new BronzePlating();
    }
}
