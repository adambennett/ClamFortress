package main.models.buildings.concrete.housing;

import main.models.buildings.abstracts.*;
import main.models.resources.natural.*;

public class MediumRockHome extends AbstractHouse {

    public MediumRockHome() {
        super("Medium Rock Home", 34, 400, new Rock());
    }

    @Override
    public MediumRockHome clone() {
        return new MediumRockHome();
    }
}
