package main.models.buildings.concrete.housing;

import main.models.buildings.abstracts.*;
import main.models.resources.*;
import main.models.resources.natural.*;

public class MediumWoodHome extends AbstractHouse {

    public MediumWoodHome() {
        super("Medium Wood Home", 14, 400, new Wood());
    }

    @Override
    public MediumWoodHome clone() {
        return new MediumWoodHome();
    }

}
