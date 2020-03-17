package main.models.animals.land;

import main.models.animals.*;

public class Cow extends Animal {

    public Cow(){
        this.amountOfFoodOnHunt = 200;
    }

    @Override
    public Cow clone() {
        return new Cow();
    }
}
