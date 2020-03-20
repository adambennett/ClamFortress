package main.models.resources.refined;

import main.interfaces.*;
import main.models.resources.*;

public class Art extends RefinedResource implements ResourceCost {
    public Art() {
        super("Art", "A collection of various artworks and paintings.");
    }

    @Override
    public Art clone() {
        return new Art();
    }
}
