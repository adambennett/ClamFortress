package main.models.animals.tundra;

import main.models.animals.*;
import main.models.animals.desert.*;
import main.models.animals.land.*;

public abstract class AbstractTundraAnimal extends AbstractLandAnimal {
    public AbstractTundraAnimal(int amt) {
        super(amt);
    }

    @Override
    public abstract AbstractTundraAnimal clone();
}
