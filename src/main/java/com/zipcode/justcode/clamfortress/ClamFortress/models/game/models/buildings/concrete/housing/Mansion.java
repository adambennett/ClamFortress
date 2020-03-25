package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.concrete.housing;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.refined.*;

public class Mansion extends AbstractHouse {

    public Mansion() {
        super("Mansion", 35, 1800, new Brick());
    }

    @Override
    public Mansion clone() {
        return new Mansion();
    }
}
