package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.medieval;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.*;

public class Longsword extends AbstractWeapon {

    public Longsword() {
        super("Longsword", "A standard metal longsword. Improves attack by 100.");
    }

    @Override
    public Integer modifyAtk() {
        return 100;
    }

    @Override
    public Longsword clone() {
        return new Longsword();
    }
}
