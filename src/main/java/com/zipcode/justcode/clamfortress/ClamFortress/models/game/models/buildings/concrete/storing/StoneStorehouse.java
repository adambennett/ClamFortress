package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.concrete.storing;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.refined.*;

public class StoneStorehouse extends AbstractStorehouse {

    public StoneStorehouse() {
        super("Stone Storehouse", 200, 2000, new Stone());
    }


    @Override
    public StoneStorehouse clone() {
        return new StoneStorehouse();
    }
}
