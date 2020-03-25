package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals.sea;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals.*;

public abstract class AbstractSeaAnimal extends AbstractAnimal {
    public AbstractSeaAnimal(String name, String desc, int amt) {
        super(name, desc, amt);
    }

    @Override
    public abstract AbstractSeaAnimal clone();
}
