package main.models.resources.refined;

import main.interfaces.*;
import main.models.resources.*;

public class Glass extends RefinedResource implements ResourceCost {
    public Glass() {
        super("Glass", "Created from Sand. Used to decorate your buildings.");
    }

    @Override
    public Glass clone() {
        return new Glass();
    }
}
