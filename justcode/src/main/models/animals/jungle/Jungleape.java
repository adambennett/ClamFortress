package main.models.animals.jungle;

public class Jungleape extends JungleAnimal {

    public Jungleape(){
        this.amountOfFoodOnHunt = 300;
    }
    @Override
    public Jungleape clone() {
        return new Jungleape();
    }
}
