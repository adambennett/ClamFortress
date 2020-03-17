package main.models.animals.jungle;

import main.interfaces.Mythical;

public class Jungleape extends JungleAnimal implements Mythical {

    public Jungleape(){
        this.amountOfFoodOnHunt = 300;
    }
    @Override
    public Jungleape clone() {
        return new Jungleape();
    }
}
