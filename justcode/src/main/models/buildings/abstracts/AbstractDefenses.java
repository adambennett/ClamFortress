package main.models.buildings.abstracts;

import main.models.*;
import main.models.resources.*;

public abstract class AbstractDefenses extends AbstractBuilding {

    private final Integer defense;

    public AbstractDefenses(String name, int resourceCost, int defend, AbstractResource resourceType) {
        super(name, resourceCost, resourceType);
        this.defense = defend;
    }

    @Override
    public abstract AbstractDefenses clone();
}
