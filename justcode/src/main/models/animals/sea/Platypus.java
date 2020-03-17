package main.models.animals.sea;

import main.models.animals.*;

public class Platypus extends Animal {
    @Override
    public Platypus clone() {
        return new Platypus();
    }
}
