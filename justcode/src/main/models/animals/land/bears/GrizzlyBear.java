package main.models.animals.land.bears;

public class GrizzlyBear extends Bear {

    public GrizzlyBear(){
        this.amountOfFoodOnHunt = 250;
    }
    @Override
    public GrizzlyBear clone() {
        return new GrizzlyBear();
    }
}
