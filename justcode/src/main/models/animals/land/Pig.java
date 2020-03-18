package main.models.animals.land;

import main.models.animals.land.bears.AbstractBear;

public class Pig extends AbstractLandAnimal {

    public Pig() {
        super(90);
    }

    @Override
    public Pig clone() {
        return new Pig();
    }
}
