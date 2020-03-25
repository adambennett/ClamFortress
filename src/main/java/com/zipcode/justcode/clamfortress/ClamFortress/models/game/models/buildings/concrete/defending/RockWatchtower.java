package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.concrete.defending;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural.*;

public class RockWatchtower extends AbstractDefenses {

    public RockWatchtower() {
        super("Rock Watchtower", 200, 25, new Rock());
    }

    @Override
    public RockWatchtower clone() {
        return new RockWatchtower();
    }
}
