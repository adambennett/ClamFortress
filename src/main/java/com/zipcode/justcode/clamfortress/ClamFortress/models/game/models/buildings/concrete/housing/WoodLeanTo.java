package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.concrete.housing;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural.*;

public class WoodLeanTo extends AbstractHouse {

    public WoodLeanTo() {
        super("Wood Lean To", 2, 10, new Wood());
    }

    @Override
    public WoodLeanTo clone() {
        return new WoodLeanTo();
    }
}
