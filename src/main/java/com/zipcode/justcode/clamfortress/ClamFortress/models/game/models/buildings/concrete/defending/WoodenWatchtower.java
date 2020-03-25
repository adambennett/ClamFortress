package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.concrete.defending;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural.*;

public class WoodenWatchtower extends AbstractDefenses {

    public WoodenWatchtower() {
        super("Wooden Watchtower", 150, 5, new Wood());
    }

    @Override
    public WoodenWatchtower clone() {
        return new WoodenWatchtower();
    }
}
