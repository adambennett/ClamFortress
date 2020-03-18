package main.models.buildings.concrete.defending;

import main.models.buildings.abstracts.*;
import main.models.resources.*;
import main.models.resources.natural.*;

public class WoodenWatchtower extends AbstractDefenses {

    public WoodenWatchtower() {
        super("Wooden Watchtower", 150, 5, new Wood());
    }
}
