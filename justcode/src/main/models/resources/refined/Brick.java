package main.models.resources.refined;

import main.interfaces.*;
import main.models.resources.*;

public class Brick extends RefinedResource implements ResourceCost {
    public Brick() {
        super("Brick", "Used to craft very sturdy buildings.");
    }

    @Override
    public Brick clone() {
        return new Brick();
    }
}
