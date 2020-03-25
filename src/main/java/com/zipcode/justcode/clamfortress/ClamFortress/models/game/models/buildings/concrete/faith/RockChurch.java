package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.concrete.faith;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural.*;

public class RockChurch extends AbstractFaithBuilding {

    public RockChurch() {
        super("Rock Church", 160, 60, 100, new Rock());
    }

    @Override
    public RockChurch clone() {
        return new RockChurch();
    }
}
