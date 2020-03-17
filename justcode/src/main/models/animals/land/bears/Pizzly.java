package main.models.animals.land.bears;

public class Pizzly extends Bear {

    public Pizzly(){
        this.amountOfFoodOnHunt = 250;
    }
    @Override
    public Pizzly clone() {
        return new Pizzly();
    }
}
