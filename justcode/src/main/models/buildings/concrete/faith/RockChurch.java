package main.models.buildings.concrete.faith;

import main.models.*;
import main.models.buildings.abstracts.*;
import main.models.resources.*;
import main.models.resources.natural.*;

public class RockChurch extends AbstractFaithBuilding {

    public RockChurch() {
        super("Rock Church", 160, 60, 100, new Rock());
    }

    @Override
    public RockChurch clone() {
        return new RockChurch();
    }
}
