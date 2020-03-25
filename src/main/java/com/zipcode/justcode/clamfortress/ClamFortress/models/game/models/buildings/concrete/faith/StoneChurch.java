package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.concrete.faith;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.refined.*;

public class StoneChurch extends AbstractFaithBuilding {

    public StoneChurch() {
        super("Stone Church", 50, 30, 50, new Stone());
    }

    @Override
    public StoneChurch clone() {
        return new StoneChurch();
    }
}
