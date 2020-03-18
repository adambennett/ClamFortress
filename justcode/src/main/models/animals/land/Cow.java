package main.models.animals.land;

import main.models.animals.*;

public class Cow extends AbstractLandAnimal {

    public Cow() {
        super(200);
    }

    @Override
    public Cow clone() {
        return new Cow();
    }
}
