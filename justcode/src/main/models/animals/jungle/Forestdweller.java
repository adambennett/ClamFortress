package main.models.animals.jungle;

public class Forestdweller extends AbstractJungleAnimal {

    public Forestdweller() {
        super(275);
    }

    @Override
    public Forestdweller clone() {
        return new Forestdweller();
    }
}
