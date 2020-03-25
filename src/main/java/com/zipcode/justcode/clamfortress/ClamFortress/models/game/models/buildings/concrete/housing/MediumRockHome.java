package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.concrete.housing;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural.*;

public class MediumRockHome extends AbstractHouse {

    public MediumRockHome() {
        super("Medium Rock Home", 34, 400, new Rock());
    }

    @Override
    public MediumRockHome clone() {
        return new MediumRockHome();
    }
}
