package main.models.animals.land;

import main.models.animals.*;

public class Horse extends Animal {

    public Horse() {
        super(210);
    }

    @Override
    public Horse clone() {
        return new Horse();
    }
}
