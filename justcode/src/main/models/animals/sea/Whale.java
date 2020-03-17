package main.models.animals.sea;

public class Whale extends SeaAnimal {

    public Whale(){
        this.amountOfFoodOnHunt = 450;
    }

    @Override
    public Whale clone() {
        return new Whale();
    }
}
