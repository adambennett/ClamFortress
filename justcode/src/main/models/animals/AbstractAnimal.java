package main.models.animals;

public abstract class AbstractAnimal implements Cloneable {

    private Integer amountOfFoodOnHunt;

    public AbstractAnimal(int amt) {
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
