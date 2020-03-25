package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.ammo;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.medieval.*;

public class Arrows extends AbstractAmmo {

    public Arrows() {
        super("Arrows", "Improves the damage of Bows by 100.");
    }

    @Override
    public Integer modifyWeaponDmg(AbstractWeapon weapon) {
        if (weapon instanceof Bow) {
            return 100;
        }
        return 0;
    }

    @Override
    public Arrows clone() {
        return new Arrows();
    }
}
