package main.models.animals.jungle;

import main.interfaces.Mythical;

public class Wildabeast extends JungleAnimal implements Mythical {

    public Wildabeast(){
        this.amountOfFoodOnHunt = 260;
    }
    @Override
    public Wildabeast clone() {
        return new Wildabeast();
    }
}
