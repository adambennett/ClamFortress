package main.models.animals.land.bears;

import main.models.animals.*;
import main.models.animals.land.*;
import main.models.animals.mountain.*;

public abstract class AbstractBear extends AbstractLandAnimal {
    public AbstractBear(int amt) {
        super(amt);
    }

    @Override
    public abstract AbstractBear clone();
}
