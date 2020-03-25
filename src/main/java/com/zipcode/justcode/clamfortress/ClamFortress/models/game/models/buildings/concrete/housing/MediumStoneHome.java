package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.concrete.housing;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.refined.*;

public class MediumStoneHome extends AbstractHouse {

    public MediumStoneHome() {
        super("Medium Stone Home", 24, 400, new Stone());
    }

    @Override
    public MediumStoneHome clone() {
        return new MediumStoneHome();
    }
}
