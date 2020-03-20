package main.models.resources.refined;

import main.models.resources.*;

public class CopperIngot extends RefinedResource {
    public CopperIngot() {
        super("Copper Ingot", "Created from Copper. Used for various purposes.");
    }

    @Override
    public CopperIngot clone() {
        return new CopperIngot();
    }
}
