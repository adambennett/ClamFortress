package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals.tundra;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals.land.*;

public abstract class AbstractTundraAnimal extends AbstractLandAnimal {
    public AbstractTundraAnimal(String name, String desc, int amt) {
        super(name, desc, amt);
    }

    @Override
    public abstract AbstractTundraAnimal clone();
}
