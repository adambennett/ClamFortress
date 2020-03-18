package main.models.animals.land;

import main.models.animals.*;

public abstract class AbstractLandAnimal extends AbstractAnimal {
    public AbstractLandAnimal(String name, int amt) {
        super(name, amt);
    }

    @Override
    public abstract AbstractLandAnimal clone();
}
