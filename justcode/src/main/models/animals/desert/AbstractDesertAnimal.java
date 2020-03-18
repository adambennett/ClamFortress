package main.models.animals.desert;

import main.models.animals.AbstractAnimal;
import main.models.animals.jungle.*;
import main.models.animals.land.*;

public abstract class AbstractDesertAnimal extends AbstractLandAnimal {
    public AbstractDesertAnimal(int amt) {
        super(amt);
    }

    @Override
    public abstract AbstractDesertAnimal clone();
}
