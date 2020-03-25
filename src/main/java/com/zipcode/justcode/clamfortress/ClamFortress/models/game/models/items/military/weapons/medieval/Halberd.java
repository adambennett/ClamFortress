package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.medieval;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.*;

public class Halberd extends AbstractWeapon {

    public Halberd() {
        super("Halberd", "A standard metal halberd. Improves attack by 40.");
    }

    @Override
    public Integer modifyAtk() {
        return 40;
    }

    @Override
    public Halberd clone() {
        return new Halberd();
    }
}
