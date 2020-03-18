package main.models.resources.refined;

import main.models.resources.*;

public class IronIngot extends RefinedResource {
    public IronIngot() {
        super("Iron Ingot");
    }

    @Override
    public IronIngot clone() {
        return new IronIngot();
    }
}
