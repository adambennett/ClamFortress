package main.models.animals.desert;

public class Lizard extends AbstractDesertAnimal {

    public Lizard() {
        super("Lizard", 15);
    }

    @Override
    public Lizard clone() {
        return new Lizard();
    }
}
