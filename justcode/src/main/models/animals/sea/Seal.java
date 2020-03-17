package main.models.animals.sea;

public class Seal extends SeaAnimal {

    public Seal(){
        this.amountOfFoodOnHunt = 120;
    }

    @Override
    public Seal clone() {
        return new Seal();
    }
}
