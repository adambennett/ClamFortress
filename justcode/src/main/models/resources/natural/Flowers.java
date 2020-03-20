package main.models.resources.natural;

import main.interfaces.*;
import main.models.resources.*;

public class Flowers extends NaturalResource implements ResourceCost {

    public Flowers() {
        super("Flowers", "Used to make various refined resources.");
    }

    @Override
    public Flowers clone() {
        return new Flowers();
    }
}
