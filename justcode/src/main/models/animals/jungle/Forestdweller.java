package main.models.animals.jungle;

import main.interfaces.Mythical;

public class Forestdweller extends JungleAnimal implements Mythical {

    public Forestdweller(){
        this.amountOfFoodOnHunt = 275;
    }
    @Override
    public Forestdweller clone() {
        return new Forestdweller();
    }
}
