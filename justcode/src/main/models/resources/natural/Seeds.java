package main.models.resources.natural;

import main.interfaces.*;
import main.models.resources.*;

public class Seeds extends NaturalResource implements ResourceCost {
    public Seeds() {
        super("Seeds");
    }

    @Override
    public Seeds clone() {
        return new Seeds();
    }
}
