package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.ammo;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.medieval.*;

public class FlamingSwordOil extends AbstractAmmo {

    public FlamingSwordOil() {
        super("Flaming Sword Oil", "Improves the damage of Swords and Spears by 50.");
    }

    @Override
    public Integer modifyWeaponDmg(AbstractWeapon weapon) {
        if (weapon instanceof Sword || weapon instanceof Spear) {
            return 50;
        }
        return 0;
    }

    @Override
    public FlamingSwordOil clone() {
        return new FlamingSwordOil();
    }
}
