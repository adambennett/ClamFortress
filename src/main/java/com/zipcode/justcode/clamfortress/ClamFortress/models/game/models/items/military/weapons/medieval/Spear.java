package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.medieval;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.*;

public class Spear extends AbstractWeapon {

    public Spear() {
        super("Spear", "A standard metal spear. Improves attack by 55.");
    }

    @Override
    public Integer modifyAtk() {
        return 55;
    }

    @Override
    public Spear clone() {
        return new Spear();
    }
}
