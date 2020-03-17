package main.models.animals.desert;

public class Scorpion extends DesertAnimal {


    public Scorpion() {
        super(5);
    }

    @Override
    public Scorpion clone() {
        return new Scorpion();
    }
}
