package main.models.buildings.concrete.housing;

import main.models.buildings.abstracts.*;
import main.models.resources.natural.*;

public class SmallRockHome extends AbstractHouse {

    public SmallRockHome() {
        super("Small Rock Home", 28, 250, new Rock());
    }
}
