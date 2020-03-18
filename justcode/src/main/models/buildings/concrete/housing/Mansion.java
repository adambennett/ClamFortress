package main.models.buildings.concrete.housing;

import main.models.buildings.abstracts.*;
import main.models.resources.natural.*;
import main.models.resources.refined.*;

public class Mansion extends AbstractHouse {

    public Mansion() {
        super("Mansion", 35, 1800, new Brick());
    }

    @Override
    public Mansion clone() {
        return new Mansion();
    }
}
