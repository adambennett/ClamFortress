package main.models.animals.tundra;

import main.models.animals.*;
import main.models.animals.desert.*;
import main.models.animals.land.*;

public abstract class AbstractTundraAnimal extends AbstractLandAnimal {
    public AbstractTundraAnimal(String name, String desc, int amt) {
        super(name, desc, amt);
    }

    @Override
    public abstract AbstractTundraAnimal clone();
}
