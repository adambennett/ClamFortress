package main.models.animals.land;

import main.models.animals.*;

public class Duck extends Animal {

    public Duck(){
        this.amountOfFoodOnHunt = 14;
    }

    @Override
    public Duck clone() {
        return new Duck();
    }
}
