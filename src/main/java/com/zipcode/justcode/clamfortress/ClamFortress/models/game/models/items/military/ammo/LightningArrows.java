package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.ammo;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.medieval.*;

public class LightningArrows extends AbstractAmmo {

    public LightningArrows() {
        super("Lightning Arrows", "Improves the damage of Bows by 5000.");
    }

    @Override
    public Integer modifyWeaponDmg(AbstractWeapon weapon) {
        if (weapon instanceof Bow) {
            return 5000;
        }
        return 0;
    }

    @Override
    public LightningArrows clone() {
        return new LightningArrows();
    }
}
