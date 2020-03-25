package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals.mountain;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals.land.*;

public abstract class AbstractMountainAnimal extends AbstractLandAnimal {
    public AbstractMountainAnimal(String name, String desc, int amt) {
        super(name, desc, amt);
    }

    @Override
    public abstract AbstractMountainAnimal clone();

}
