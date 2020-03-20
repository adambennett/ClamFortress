package main.models.animals.jungle;

import main.models.animals.AbstractAnimal;
import main.models.animals.land.*;
import main.models.animals.land.bears.*;

public abstract class AbstractJungleAnimal extends AbstractLandAnimal {
    public AbstractJungleAnimal(String name, String desc, int amt) {
        super(name, desc, amt);
    }

    @Override
    public abstract AbstractJungleAnimal clone();
}
