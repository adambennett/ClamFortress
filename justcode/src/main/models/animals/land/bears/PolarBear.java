package main.models.animals.land.bears;

public class PolarBear extends Bear {

    public PolarBear(){
        this.amountOfFoodOnHunt = 250;
    }
    @Override
    public PolarBear clone() {
        return new PolarBear();
    }
}
