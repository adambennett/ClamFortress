package main.models.animals.land;

import main.models.animals.*;

public class Duck extends AbstractLandAnimal {

    public Duck() {
        super("Duck", 14);
    }

    @Override
    public Duck clone() {
        return new Duck();
    }
}
