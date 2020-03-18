package main.models.animals.mountain;

import main.models.animals.AbstractAnimal;
import main.models.animals.land.*;
import main.models.animals.sea.*;

public abstract class AbstractMountainAnimal extends AbstractLandAnimal {
    public AbstractMountainAnimal(int amt) {
        super(amt);
    }

    @Override
    public abstract AbstractMountainAnimal clone();

}
