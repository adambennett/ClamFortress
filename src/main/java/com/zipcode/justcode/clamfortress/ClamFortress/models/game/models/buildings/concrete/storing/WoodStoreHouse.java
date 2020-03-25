package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.concrete.storing;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural.*;

public class WoodStoreHouse extends AbstractStorehouse {

    public WoodStoreHouse() {
        super("Wood Storehouse", 0, 1000, new Wood());
    }

    @Override
    public WoodStoreHouse clone() {
        return new WoodStoreHouse();
    }
}
