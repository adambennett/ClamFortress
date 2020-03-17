package main.models.animals;

public abstract class Animal implements Cloneable {

    public Integer amountOfFoodOnHunt;


    public Integer getAmountOfFoodOnHunt(){
        return this.amountOfFoodOnHunt;
    }

    @Override
    public abstract Animal clone();

}
