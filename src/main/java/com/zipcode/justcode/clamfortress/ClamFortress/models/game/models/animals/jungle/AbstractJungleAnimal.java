package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals.jungle;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals.land.*;

public abstract class AbstractJungleAnimal extends AbstractLandAnimal {
    public AbstractJungleAnimal(String name, String desc, int amt) {
        super(name, desc, amt);
    }

    @Override
    public abstract AbstractJungleAnimal clone();
}
