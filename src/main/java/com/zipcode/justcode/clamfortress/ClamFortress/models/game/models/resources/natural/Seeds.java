package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.*;

public class Seeds extends NaturalResource implements ResourceCost {
    public Seeds() {
        super("Seeds", "Plant them to Harvest a lot of food!");
    }

    @Override
    public Seeds clone() {
        return new Seeds();
    }
}
