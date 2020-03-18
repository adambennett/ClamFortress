package main.models.buildings.concrete.storing;

import main.models.buildings.abstracts.*;
import main.models.resources.*;
import main.models.resources.natural.*;

public class WoodStoreHouse extends AbstractStorehouse {

    public WoodStoreHouse(String name, int resourceCost, int storageInc, AbstractResource resourceType) {
        super("Wood Storehouse", 0, 1000, new Wood());
    }
}
