package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals.desert;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals.land.*;

public abstract class AbstractDesertAnimal extends AbstractLandAnimal {
    public AbstractDesertAnimal(String name, String desc, int amt) {
        super(name, desc, amt);
    }

    @Override
    public abstract AbstractDesertAnimal clone();
}
