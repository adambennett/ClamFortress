package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.concrete.defending;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.refined.*;

public class StoneWatchtower extends AbstractDefenses {

    public StoneWatchtower() {
        super("Stone Watchtower", 150, 8, new Stone());
    }

    @Override
    public StoneWatchtower clone() {
        return new StoneWatchtower();
    }
}
