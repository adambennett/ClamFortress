package main.models.animals.land;

import main.models.animals.*;

public class Buffalo extends Animal {
    @Override
    public Buffalo clone() {
        return new Buffalo();
    }
}
