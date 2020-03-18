package main.models.resources.natural;

import main.interfaces.*;
import main.models.resources.*;

public class Flowers extends NaturalResource implements ResourceCost {

    public Flowers() {
        super("Flowers");
    }

    @Override
    public Flowers clone() {
        return new Flowers();
    }
}
