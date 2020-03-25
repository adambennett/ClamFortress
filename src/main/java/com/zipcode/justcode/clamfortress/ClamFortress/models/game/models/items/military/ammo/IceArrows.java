package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.ammo;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.medieval.*;

public class IceArrows extends AbstractAmmo {

    public IceArrows() {
        super("Ice Arrows", "Improves the damage of Bows by 250.");
    }

    @Override
    public Integer modifyWeaponDmg(AbstractWeapon weapon) {
        if (weapon instanceof Bow) {
            return 250;
        }
        return 0;
    }

    @Override
    public IceArrows clone() {
        return new IceArrows();
    }
}
