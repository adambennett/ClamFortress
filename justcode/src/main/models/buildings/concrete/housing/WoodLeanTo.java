package main.models.buildings.concrete.housing;

import main.models.buildings.abstracts.*;
import main.models.resources.*;
import main.models.resources.natural.*;

public class WoodLeanTo extends AbstractHouse {

    public WoodLeanTo() {
        super("Wood Lean To", 2, 10, new Wood());
    }

    @Override
    public WoodLeanTo clone() {
        return new WoodLeanTo();
    }
}
