package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.ammo;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.medieval.*;

public class FlamingArrows extends AbstractAmmo {

    public FlamingArrows() {
        super("Flaming Arrows", "Improves the damage of Bows by 500.");
    }

    @Override
    public Integer modifyWeaponDmg(AbstractWeapon weapon) {
        if (weapon instanceof Bow) {
            return 500;
        }
        return 0;
    }

    @Override
    public FlamingArrows clone() {
        return new FlamingArrows();
    }
}
