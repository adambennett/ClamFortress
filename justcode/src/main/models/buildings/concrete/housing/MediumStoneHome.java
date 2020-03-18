package main.models.buildings.concrete.housing;

import main.models.buildings.abstracts.*;
import main.models.resources.natural.*;
import main.models.resources.refined.*;

public class MediumStoneHome extends AbstractHouse {

    public MediumStoneHome() {
        super("Medium Stone Home", 24, 400, new Stone());
    }
}
