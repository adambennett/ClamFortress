package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.concrete.faith;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural.*;

public class WoodenChurch extends AbstractFaithBuilding {

    public WoodenChurch() {
        super("Wooden Church", 15, 15, 25, new Wood());
    }

    @Override
    public WoodenChurch clone() {
        return new WoodenChurch();
    }
}
