package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.*;

public class Flowers extends NaturalResource implements ResourceCost {

    public Flowers() {
        super("Flowers", "Used to make various refined resources.");
    }

    @Override
    public Flowers clone() {
        return new Flowers();
    }
}
