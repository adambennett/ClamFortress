package main.models.animals.tundra;

import main.models.animals.*;
import main.models.animals.desert.*;
import main.models.animals.land.*;

public abstract class AbstractTundraAnimal extends AbstractLandAnimal {
    public AbstractTundraAnimal(String name, int amt) {
        super(name, amt);
    }

    @Override
    public abstract AbstractTundraAnimal clone();
}
