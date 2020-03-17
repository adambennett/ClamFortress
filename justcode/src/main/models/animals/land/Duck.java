package main.models.animals.land;

import main.models.animals.*;

public class Duck extends Animal {
    @Override
    public Duck clone() {
        return new Duck();
    }
}
