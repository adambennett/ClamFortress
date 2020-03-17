package main.models.animals.land.bears;

public class Panda extends Bear {

    public Panda(){
        this.amountOfFoodOnHunt = 250;
    }
    @Override
    public Panda clone() {
        return new Panda();
    }
}
