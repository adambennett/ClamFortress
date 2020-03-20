package main.models.resources.refined;

import main.interfaces.*;
import main.models.resources.*;

public class Jewelery extends RefinedResource implements ResourceCost {
    public Jewelery() {
        super("Jewelery", "Worth quite a lot of money!");
    }

    @Override
    public Jewelery clone() {
        return new Jewelery();
    }
}
