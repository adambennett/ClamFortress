package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.medieval;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.*;

public class Shortsword extends AbstractWeapon {

    public Shortsword() {
        super("Shortsword", "A standard metal shortsword. Improves attack by 30.");
    }

    @Override
    public Integer modifyAtk() {
        return 30;
    }

    @Override
    public Shortsword clone() {
        return new Shortsword();
    }
}
