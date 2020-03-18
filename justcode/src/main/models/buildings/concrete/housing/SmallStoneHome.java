package main.models.buildings.concrete.housing;

import main.models.buildings.abstracts.*;
import main.models.resources.natural.*;
import main.models.resources.refined.*;

public class SmallStoneHome extends AbstractHouse {

    public SmallStoneHome() {
        super("Small Stone Home", 18, 250, new Stone());
    }

    @Override
    public SmallStoneHome clone() {
        return new SmallStoneHome();
    }
}
