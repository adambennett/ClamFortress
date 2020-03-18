package main.models.animals.land;

import main.models.animals.*;

public class Dog extends AbstractLandAnimal {

    public Dog() {
        super(45);
    }

    @Override
    public Dog clone() {
        return new Dog();
    }
}
