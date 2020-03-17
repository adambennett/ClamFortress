package main.models.animals.jungle;

public class Forestdweller extends JungleAnimal {

    public Forestdweller(){
        this.amountOfFoodOnHunt = 275;
    }
    @Override
    public Forestdweller clone() {
        return new Forestdweller();
    }
}
