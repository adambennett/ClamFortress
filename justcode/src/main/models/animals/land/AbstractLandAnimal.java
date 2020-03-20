package main.models.animals.land;

import main.models.animals.*;

public abstract class AbstractLandAnimal extends AbstractAnimal {
    public AbstractLandAnimal(String name, String desc, int amt) {
        super(name, desc, amt);
    }

    @Override
    public abstract AbstractLandAnimal clone();
}
