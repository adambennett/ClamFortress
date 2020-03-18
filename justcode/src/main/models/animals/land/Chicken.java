package main.models.animals.land;

import main.models.animals.*;

public class Chicken extends AbstractLandAnimal {

    public Chicken() {
        super("Chicken", 18);
    }

    @Override
    public Chicken clone() {
        return new Chicken();
    }
}
