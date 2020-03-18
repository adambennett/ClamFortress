package main.models.buildings.concrete.faith;

import main.models.*;
import main.models.buildings.abstracts.*;
import main.models.resources.*;
import main.models.resources.natural.*;
import main.models.resources.refined.*;

public class StoneChurch extends AbstractFaithBuilding {

    public StoneChurch() {
        super("Stone Church", 50, 30, 50, new Stone());
    }

    @Override
    public StoneChurch clone() {
        return new StoneChurch();
    }
}
