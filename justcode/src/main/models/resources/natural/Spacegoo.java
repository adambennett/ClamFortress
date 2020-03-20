package main.models.resources.natural;

import main.interfaces.*;
import main.models.resources.*;

public class Spacegoo extends NaturalResource implements ResourceCost {
    public Spacegoo() {
        super("Spacegoo", "Worth a LOT of money!! Or should you use it?");
    }

    @Override
    public Spacegoo clone() {
        return new Spacegoo();
    }
}
