package main.models.buildings.concrete.housing;

import main.models.buildings.abstracts.*;
import main.models.resources.natural.*;
import main.models.resources.refined.*;

public class LargeStoneHome extends AbstractHouse {

    public LargeStoneHome() {
        super("Large Stone Home", 30, 800, new Stone());
    }
}
