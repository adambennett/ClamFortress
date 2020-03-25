package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.medieval;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.*;

public class Katana extends AbstractWeapon {

    public Katana() {
        super("Katana", "A standard samurai sword. Improves attack by 95.");
    }

    @Override
    public Integer modifyAtk() {
        return 95;
    }

    @Override
    public Katana clone() {
        return new Katana();
    }
}
