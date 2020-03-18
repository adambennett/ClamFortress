package main.models.buildings.concrete.faith;

import main.models.buildings.abstracts.*;
import main.models.resources.*;
import main.models.resources.natural.*;

public class WoodenChurch extends AbstractFaithBuilding {

    public WoodenChurch() {
        super("Wooden Church", 15, 15, new Wood());
    }
}
