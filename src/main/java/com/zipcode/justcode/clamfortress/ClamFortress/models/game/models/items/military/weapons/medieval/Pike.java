package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.medieval;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.*;

public class Pike extends AbstractWeapon {

    public Pike() {
        super("Pike", "A long, slender steel pike. Improves attack by 65.");
    }

    @Override
    public Integer modifyAtk() {
        return 65;
    }

    @Override
    public Pike clone() {
        return new Pike();
    }
}
