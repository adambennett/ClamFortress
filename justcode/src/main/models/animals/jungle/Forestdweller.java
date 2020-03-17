package main.models.animals.jungle;

public class Forestdweller extends JungleAnimal {

    public Forestdweller() {
        super(275);
    }

    @Override
    public Forestdweller clone() {
        return new Forestdweller();
    }
}
