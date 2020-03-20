package main.models.animals.land.bears;

import main.models.animals.*;
import main.models.animals.land.*;
import main.models.animals.mountain.*;

public abstract class AbstractBear extends AbstractLandAnimal {
    public AbstractBear(String name, String desc, int amt) {
        super(name, desc, amt);
    }

    @Override
    public abstract AbstractBear clone();
}
