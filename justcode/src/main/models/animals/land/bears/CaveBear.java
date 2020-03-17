package main.models.animals.land.bears;

public class CaveBear extends Bear {

    public CaveBear(){
        this.amountOfFoodOnHunt = 250;
    }
    @Override
    public CaveBear clone() {
        return new CaveBear();
    }
}
