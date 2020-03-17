package main.models.animals.jungle;

public class Jungleape extends JungleAnimal {

    public Jungleape() {
        super(300);
    }

    @Override
    public Jungleape clone() {
        return new Jungleape();
    }
}
