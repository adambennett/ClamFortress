package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.medieval;

import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.*;

public class Javelin extends AbstractWeapon {

    public Javelin() {
        super("Javelin", "A standard metal javelin. Improves attack by 35.");
    }

    @Override
    public Integer modifyAtk() {
        return 35;
    }

    @Override
    public Javelin clone() {
        return new Javelin();
    }
}
