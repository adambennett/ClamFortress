package main.models.animals.jungle;

public class Jungleape extends AbstractJungleAnimal {

    public Jungleape() {
        super("Jungleape", 300);
    }

    @Override
    public Jungleape clone() {
        return new Jungleape();
    }
}
