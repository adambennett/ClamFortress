package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.concrete.housing;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.refined.*;

public class StoneLeanTo extends AbstractHouse {

    public StoneLeanTo() {
        super("Stone Lean To", 6, 15, new Stone());
    }

    @Override
    public StoneLeanTo clone() {
        return new StoneLeanTo();
    }
}
