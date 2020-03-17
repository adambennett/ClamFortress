package main.models.animals.land;

import main.models.animals.*;

public class Cat extends Animal {
    @Override
    public Cat clone() {
        return new Cat();
    }
}
