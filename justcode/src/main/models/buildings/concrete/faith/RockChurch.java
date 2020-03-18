package main.models.buildings.concrete.faith;

import main.models.buildings.abstracts.*;
import main.models.resources.*;
import main.models.resources.natural.*;

public class RockChurch extends AbstractFaithBuilding {

    public RockChurch() {
        super("Rock Church", 160, 60, new Rock());
    }
}
