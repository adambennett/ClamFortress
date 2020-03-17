package main.models.animals.sea;

public class Fish extends SeaAnimal {

    public Fish(){
        this.amountOfFoodOnHunt = 20;
    }

    @Override
    public Fish clone() {
        return new Fish();
    }
}
