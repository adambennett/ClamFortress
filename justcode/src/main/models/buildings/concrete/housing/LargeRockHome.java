package main.models.buildings.concrete.housing;

import main.models.buildings.abstracts.*;
import main.models.resources.natural.*;

public class LargeRockHome extends AbstractHouse {

    public LargeRockHome() {
        super("Large Rock Home", 40, 800, new Rock());
    }
}
