package main.models.animals.mountain;

import main.models.animals.AbstractAnimal;
import main.models.animals.land.*;
import main.models.animals.sea.*;

public abstract class AbstractMountainAnimal extends AbstractLandAnimal {
    public AbstractMountainAnimal(String name, String desc, int amt) {
        super(name, desc, amt);
    }

    @Override
    public abstract AbstractMountainAnimal clone();

}
