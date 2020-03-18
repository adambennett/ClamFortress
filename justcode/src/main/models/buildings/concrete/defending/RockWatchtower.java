package main.models.buildings.concrete.defending;

import main.models.buildings.abstracts.*;
import main.models.resources.natural.*;
import main.models.resources.refined.*;

public class RockWatchtower extends AbstractDefenses {

    public RockWatchtower() {
        super("Rock Watchtower", 200, 25, new Rock());
    }
}
