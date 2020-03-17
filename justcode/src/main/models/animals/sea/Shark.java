package main.models.animals.sea;

public class Shark extends SeaAnimal {

    public Shark(){
        this.amountOfFoodOnHunt = 175;
    }

    @Override
    public Shark clone() {
        return new Shark();
    }
}
