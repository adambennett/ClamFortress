package main.models.animals.desert;

import main.models.animals.*;

public class Armadillo extends DesertAnimal {

    @Override
    public Armadillo clone() {
        return new Armadillo();
    }
}
