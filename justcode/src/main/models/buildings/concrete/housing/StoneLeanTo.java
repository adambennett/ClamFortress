package main.models.buildings.concrete.housing;

import main.models.buildings.abstracts.*;
import main.models.resources.natural.*;
import main.models.resources.refined.*;

public class StoneLeanTo extends AbstractHouse {

    public StoneLeanTo() {
        super("Stone Lean To", 6, 15, new Stone());
    }
}
