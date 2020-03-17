package main.models.animals.desert;

public class Camel extends DesertAnimal {

    public Camel(){
        this.amountOfFoodOnHunt = 175;
    }
    @Override
    public Camel clone() {
        return new Camel();
    }
}
