package main.models.animals.land;

import main.models.animals.*;

public class Horse extends Animal {
    @Override
    public Horse clone() {
        return new Horse();
    }
}
