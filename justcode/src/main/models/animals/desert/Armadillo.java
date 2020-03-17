package main.models.animals.desert;

public class Armadillo extends DesertAnimal {

    public Armadillo() {
        super(10);
    }

    @Override
    public Armadillo clone() {
        return new Armadillo();
    }
}
