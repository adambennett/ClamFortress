package clamFortress.models.animals;

public abstract class Animal {

    Integer amountOfFoodOnButcher;

    public void setAmountOfFoodOnButcher(Integer amount){
        this.amountOfFoodOnButcher = amount;
    }

    public Integer getAmountOfFoodOnButcher(){
        return amountOfFoodOnButcher;
    }
}
