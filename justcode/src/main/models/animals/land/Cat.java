package main.models.animals.land;

import main.models.animals.*;

public class Cat extends Animal {

    public Cat() {
        super(22);
    }

    @Override
    public Cat clone() {
        return new Cat();
    }
}
