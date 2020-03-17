package main.models.animals.jungle;

public class Wildabeast extends JungleAnimal {

    public Wildabeast(){
        this.amountOfFoodOnHunt = 260;
    }
    @Override
    public Wildabeast clone() {
        return new Wildabeast();
    }
}
