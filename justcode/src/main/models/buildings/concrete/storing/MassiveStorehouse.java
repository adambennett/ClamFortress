package main.models.buildings.concrete.storing;

import main.models.buildings.abstracts.*;
import main.models.buildings.concrete.housing.*;
import main.models.resources.*;
import main.models.resources.natural.*;
import main.models.resources.refined.*;

public class MassiveStorehouse extends AbstractStorehouse {

    public MassiveStorehouse() {
        super("Massive Storehouse", 1000, 20000, new Brick());
    }


    @Override
    public MassiveStorehouse clone() {
        return new MassiveStorehouse();
    }
}
