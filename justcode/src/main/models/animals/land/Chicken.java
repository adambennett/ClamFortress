package main.models.animals.land;

import main.models.animals.*;

public class Chicken extends Animal {

    public Chicken(){
        this.amountOfFoodOnHunt = 18;
    }

    @Override
    public Chicken clone() {
        return new Chicken();
    }
}
