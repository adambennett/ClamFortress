package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.ammo;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.*;

public abstract class AbstractAmmo extends AbstractMilitaryItem {
    public AbstractAmmo(String name, String desc) {
        super(name, desc);
    }

    @Override
    public abstract Integer modifyWeaponDmg(AbstractWeapon weapon);

    @Override
    public abstract AbstractAmmo clone();
}
