package main.models.animals;

import main.models.*;

public abstract class AbstractAnimal extends GameObject {

    private Integer amountOfFoodOnHunt;

    public AbstractAnimal(String name, int amt) {
        super(name);
        this.amountOfFoodOnHunt = amt;
    }

    public Integer getAmountOfFoodOnHunt(){
        return this.amountOfFoodOnHunt;
    }

    public void setAmountOfFoodOnHunt(int amt) {
        this.amountOfFoodOnHunt = amt;
    }

    @Override
    public abstract AbstractAnimal clone();

}
