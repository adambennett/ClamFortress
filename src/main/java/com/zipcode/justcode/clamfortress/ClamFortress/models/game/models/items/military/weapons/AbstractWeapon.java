package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons;

import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.*;

public abstract class AbstractWeapon extends AbstractMilitaryItem {
    public AbstractWeapon(String name, String desc) {
        super(name, desc);
    }

    @Override
    public abstract Integer modifyAtk();

    @Override
    public abstract AbstractWeapon clone();
}
