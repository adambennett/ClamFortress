package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.concrete.housing;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.refined.*;

public class LargeStoneHome extends AbstractHouse {

    public LargeStoneHome() {
        super("Large Stone Home", 30, 800, new Stone());
    }


    @Override
    public LargeStoneHome clone() {
        return new LargeStoneHome();
    }
}
