package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.concrete.housing;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.refined.*;

public class SmallStoneHome extends AbstractHouse {

    public SmallStoneHome() {
        super("Small Stone Home", 18, 250, new Stone());
    }

    @Override
    public SmallStoneHome clone() {
        return new SmallStoneHome();
    }
}
