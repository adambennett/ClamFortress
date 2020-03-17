package main.models.animals.sea;


public class Dolphin extends SeaAnimal {

    public Dolphin(){
        this.amountOfFoodOnHunt = 115;
    }

    @Override
    public Dolphin clone() {
        return new Dolphin();
    }
}
