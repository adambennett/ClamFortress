package main.models.buildings.abstracts;

import main.models.resources.*;

public abstract class AbstractHouse extends AbstractBuilding {

    private final Integer popCapInc;

    public AbstractHouse(String name, int popCapInc, int resourceCost, AbstractResource resourceType) {
        super(name, resourceCost, resourceType);
        this.popCapInc = popCapInc;
    }

    public Integer getPopCapInc() {
        return popCapInc;
    }
}
