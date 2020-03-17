package main.models.animals.land;

import main.models.animals.*;

public class Dog extends Animal {
    @Override
    public Dog clone() {
        return new Dog();
    }
}
