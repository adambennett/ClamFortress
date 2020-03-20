package main.models.animals.land;

import main.models.animals.*;

public class Dog extends AbstractLandAnimal {

    public Dog() {
        super("Dog", "The domestic dog is a member of the genus Canis, which forms part of the wolf-like canids, and is the most widely abundant terrestrial carnivore.", 45);
    }

    @Override
    public Dog clone() {
        return new Dog();
    }
}
