package main.models.animals.land;

import main.models.animals.*;

public class Moose extends Animal {
    @Override
    public Moose clone() {
        return new Moose();
    }
}
