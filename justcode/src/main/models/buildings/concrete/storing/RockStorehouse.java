package main.models.buildings.concrete.storing;

import main.models.buildings.abstracts.*;
import main.models.resources.*;
import main.models.resources.natural.*;

public class RockStorehouse extends AbstractStorehouse {

    public RockStorehouse() {
        super("Rock Storehouse", 150, 2500, new Rock());
    }
}
