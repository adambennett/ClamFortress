package main.models.animals.land;

import main.models.animals.*;

public class Dog extends Animal {

    public Dog(){
        this.amountOfFoodOnHunt = 45;
    }

    @Override
    public Dog clone() {
        return new Dog();
    }
}
