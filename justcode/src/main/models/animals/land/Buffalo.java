package main.models.animals.land;

import main.models.animals.*;

public class Buffalo extends Animal {

    public Buffalo(){
        this.amountOfFoodOnHunt = 250;
    }
    @Override
    public Buffalo clone() {
        return new Buffalo();
    }
}
