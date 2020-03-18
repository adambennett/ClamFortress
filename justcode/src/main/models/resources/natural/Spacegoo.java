package main.models.resources.natural;

import main.interfaces.*;
import main.models.resources.*;

public class Spacegoo extends NaturalResource implements ResourceCost {
    public Spacegoo() {
        super("Spacegoo");
    }

    @Override
    public Spacegoo clone() {
        return new Spacegoo();
    }
}
