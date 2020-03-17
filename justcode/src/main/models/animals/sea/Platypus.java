package main.models.animals.sea;

import main.models.animals.*;

public class Platypus extends Animal {

    public Platypus(){
        this.amountOfFoodOnHunt = 20;
    }

    @Override
    public Platypus clone() {
        return new Platypus();
    }
}
