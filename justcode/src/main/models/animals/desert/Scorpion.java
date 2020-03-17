package main.models.animals.desert;

public class Scorpion extends DesertAnimal {

    public Scorpion(){
        this.amountOfFoodOnHunt = 5;
    }
    @Override
    public Scorpion clone() {
        return new Scorpion();
    }
}
