package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.concrete.storing;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.refined.*;

public class MassiveStorehouse extends AbstractStorehouse {

    public MassiveStorehouse() {
        super("Massive Storehouse", 1000, 20000, new Brick());
    }


    @Override
    public MassiveStorehouse clone() {
        return new MassiveStorehouse();
    }
}
