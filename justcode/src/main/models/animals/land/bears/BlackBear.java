package main.models.animals.land.bears;

public class BlackBear extends Bear {

    public BlackBear(){
        this.amountOfFoodOnHunt = 250;
    }
    @Override
    public BlackBear clone() {
        return new BlackBear();
    }
}
