package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;


public abstract class AbstractAnimal extends GameObject {

    private Integer amountOfFoodOnHunt;

    public AbstractAnimal() { super("Animal", "Description"); }

    public AbstractAnimal(String name, String desc, int amt) {
        super(name, desc);
        this.amountOfFoodOnHunt = amt;
    }

    public Integer getAmountOfFoodOnHunt(){
        return this.amountOfFoodOnHunt;
    }

    public void setAmountOfFoodOnHunt(int amt) {
        this.amountOfFoodOnHunt = amt;
    }

    public void setAmountOfFoodOnHunt(Integer amountOfFoodOnHunt) {
        this.amountOfFoodOnHunt = amountOfFoodOnHunt;
    }

    @Override
    public abstract AbstractAnimal clone();

}
