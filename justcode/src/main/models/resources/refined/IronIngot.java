package main.models.resources.refined;

import main.models.resources.*;

public class IronIngot extends RefinedResource {
    public IronIngot() {
        super("Iron Ingot", "Created from Iron. Used for a handful of different purposes.");
    }

    @Override
    public IronIngot clone() {
        return new IronIngot();
    }
}
