package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals.land;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals.*;

public abstract class AbstractLandAnimal extends AbstractAnimal {
    public AbstractLandAnimal(String name, String desc, int amt) {
        super(name, desc, amt);
    }

    @Override
    public abstract AbstractLandAnimal clone();
}
