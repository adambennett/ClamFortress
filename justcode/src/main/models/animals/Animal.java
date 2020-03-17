package main.models.animals;

public abstract class Animal implements Cloneable {

    private Integer amountOfFoodOnHunt;

    public Animal(int amt) {
        this.amountOfFoodOnHunt = amt;
    }

    public Integer getAmountOfFoodOnHunt(){
        return this.amountOfFoodOnHunt;
    }

    public void setAmountOfFoodOnHunt(int amt) {
        this.amountOfFoodOnHunt = amt;
    }

    @Override
    public abstract Animal clone();

}
