package main.models.resources.refined;

import main.models.resources.*;

public class CopperIngot extends RefinedResource {
    public CopperIngot() {
        super("Copper Ingot");
    }

    @Override
    public CopperIngot clone() {
        return new CopperIngot();
    }
}
