package main.models.animals.jungle;

public class Wildabeast extends AbstractJungleAnimal {

    public Wildabeast() {
        super("Wildabeast","Best not to mess with them.", 260);
    }

    @Override
    public Wildabeast clone() {
        return new Wildabeast();
    }


}
