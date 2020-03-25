package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;

public abstract class AbstractAnimal extends GameObject {

    private Integer amountOfFoodOnHunt;

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

    @Override
    public abstract AbstractAnimal clone();

}
