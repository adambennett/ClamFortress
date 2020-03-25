package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.medieval;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.*;

public class Lance extends AbstractWeapon {

    public Lance() {
        super("Lance", "A standard metal lance. Improves attack by 75.");
    }

    @Override
    public Integer modifyAtk() {
        return 75;
    }

    @Override
    public Lance clone() {
        return new Lance();
    }
}
