package main.models.buildings.concrete.storing;

import main.models.buildings.abstracts.*;
import main.models.buildings.concrete.housing.*;
import main.models.resources.*;
import main.models.resources.natural.*;
import main.models.resources.refined.*;

public class StoneStorehouse extends AbstractStorehouse {

    public StoneStorehouse() {
        super("Stone Storehouse", 200, 2000, new Stone());
    }


    @Override
    public StoneStorehouse clone() {
        return new StoneStorehouse();
    }
}
