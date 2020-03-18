package main.models.buildings.concrete.storing;

import main.models.buildings.abstracts.*;
import main.models.buildings.concrete.housing.*;
import main.models.resources.*;
import main.models.resources.natural.*;

public class WoodStoreHouse extends AbstractStorehouse {

    public WoodStoreHouse() {
        super("Wood Storehouse", 0, 1000, new Wood());
    }

    @Override
    public WoodStoreHouse clone() {
        return new WoodStoreHouse();
    }
}
