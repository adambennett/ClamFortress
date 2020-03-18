package main.models.buildings.concrete.faith;

import main.models.buildings.abstracts.*;
import main.models.resources.*;
import main.models.resources.natural.*;
import main.models.resources.refined.*;

public class StoneChurch extends AbstractFaithBuilding {

    public StoneChurch() {
        super("Stone Church", 50, 30, new Stone());
    }
}
