package main.models.buildings.concrete.defending;

import main.models.*;
import main.models.buildings.abstracts.*;
import main.models.resources.natural.*;
import main.models.resources.refined.*;

public class StoneWatchtower extends AbstractDefenses {

    public StoneWatchtower() {
        super("Stone Watchtower", 150, 8, new Stone());
    }

    @Override
    public StoneWatchtower clone() {
        return new StoneWatchtower();
    }
}
