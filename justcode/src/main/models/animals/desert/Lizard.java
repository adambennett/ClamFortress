package main.models.animals.desert;

public class Lizard extends DesertAnimal {

    public Lizard(){
        this.amountOfFoodOnHunt = 15;
    }
    @Override
    public Lizard clone() {
        return new Lizard();
    }
}
