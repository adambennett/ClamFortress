package main.models.animals.land;

import main.models.animals.land.bears.Bear;

public class Pig extends Bear {

    public Pig() {
        super(90);
    }

    @Override
    public Pig clone() {
        return new Pig();
    }
}
