package main.models.animals.desert;

public class Armadillo extends DesertAnimal {

    public Armadillo(){
        this.amountOfFoodOnHunt = 25;
    }
    @Override
    public Armadillo clone() {
        return new Armadillo();
    }
}
