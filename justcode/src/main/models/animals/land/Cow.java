package main.models.animals.land;

import main.models.animals.*;

public class Cow extends Animal {
    @Override
    public Cow clone() {
        return new Cow();
    }
}
