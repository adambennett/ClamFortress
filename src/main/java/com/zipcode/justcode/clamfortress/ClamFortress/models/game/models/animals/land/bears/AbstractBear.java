package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals.land.bears;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals.land.*;

public abstract class AbstractBear extends AbstractLandAnimal {
    public AbstractBear(String name, String desc, int amt) {
        super(name, desc, amt);
    }

    @Override
    public abstract AbstractBear clone();
}
