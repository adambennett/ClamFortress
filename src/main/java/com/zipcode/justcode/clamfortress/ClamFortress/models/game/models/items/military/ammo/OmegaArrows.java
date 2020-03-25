package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.ammo;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.medieval.*;

public class OmegaArrows extends AbstractAmmo {

    public OmegaArrows() {
        super("Omega Arrows", "Improves the damage of Bows by 10000.");
    }

    @Override
    public Integer modifyWeaponDmg(AbstractWeapon weapon) {
        if (weapon instanceof Bow) {
            return 10000;
        }
        return 0;
    }

    @Override
    public OmegaArrows clone() {
        return new OmegaArrows();
    }
}
