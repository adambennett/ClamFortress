package main.models.animals.jungle;

public class Wildabeast extends AbstractJungleAnimal {

    public Wildabeast() {
        super(260);
    }

    @Override
    public Wildabeast clone() {
        return new Wildabeast();
    }


}
