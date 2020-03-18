package main.models.animals.desert;

public class Scorpion extends AbstractDesertAnimal {


    public Scorpion() {
        super("Scorpion", 5);
    }

    @Override
    public Scorpion clone() {
        return new Scorpion();
    }
}
