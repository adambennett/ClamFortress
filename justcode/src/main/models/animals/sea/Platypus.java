package main.models.animals.sea;

public class Platypus extends SeaAnimal {

    public Platypus(){
        this.amountOfFoodOnHunt = 20;
    }

    @Override
    public Platypus clone() {
        return new Platypus();
    }
}
