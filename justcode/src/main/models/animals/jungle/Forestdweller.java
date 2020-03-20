package main.models.animals.jungle;

public class Forestdweller extends AbstractJungleAnimal {

    public Forestdweller() {
        super("Forestdweller", "They will mess you up son!", 275);
    }

    @Override
    public Forestdweller clone() {
        return new Forestdweller();
    }
}
