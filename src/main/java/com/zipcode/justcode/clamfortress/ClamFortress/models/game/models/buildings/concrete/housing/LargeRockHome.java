package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.concrete.housing;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural.*;

public class LargeRockHome extends AbstractHouse {

    public LargeRockHome() {
        super("Large Rock Home", 40, 800, new Rock());
    }

    @Override
    public LargeRockHome clone() {
        return new LargeRockHome();
    }
}
