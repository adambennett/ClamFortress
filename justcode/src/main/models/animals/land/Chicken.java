package main.models.animals.land;

import main.models.animals.*;

public class Chicken extends Animal {
    @Override
    public Chicken clone() {
        return new Chicken();
    }
}
