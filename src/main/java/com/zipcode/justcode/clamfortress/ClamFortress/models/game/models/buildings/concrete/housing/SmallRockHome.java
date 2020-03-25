package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.concrete.housing;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural.*;

public class SmallRockHome extends AbstractHouse {

    public SmallRockHome() {
        super("Small Rock Home", 28, 250, new Rock());
    }

    @Override
    public SmallRockHome clone() {
        return new SmallRockHome();
    }
}
