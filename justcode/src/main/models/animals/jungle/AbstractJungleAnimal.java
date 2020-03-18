package main.models.animals.jungle;

import main.models.animals.AbstractAnimal;
import main.models.animals.land.*;
import main.models.animals.land.bears.*;

public abstract class AbstractJungleAnimal extends AbstractLandAnimal {
    public AbstractJungleAnimal(int amt) {
        super(amt);
    }

    @Override
    public abstract AbstractJungleAnimal clone();
}
