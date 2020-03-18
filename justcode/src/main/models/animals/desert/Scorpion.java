package main.models.animals.desert;

public class Scorpion extends AbstractDesertAnimal {


    public Scorpion() {
        super(5);
    }

    @Override
    public Scorpion clone() {
        return new Scorpion();
    }
}
