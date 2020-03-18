package main.models.animals.desert;

public class Armadillo extends AbstractDesertAnimal {

    public Armadillo() {
        super("Armadillo", 10);
    }

    @Override
    public Armadillo clone() {
        return new Armadillo();
    }
}
