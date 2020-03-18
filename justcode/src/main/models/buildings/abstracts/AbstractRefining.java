package main.models.buildings.abstracts;

import main.models.resources.*;

public abstract class AbstractRefining extends AbstractBuilding {

    private AbstractResource toRefine;

    public AbstractRefining(String name, int resourceCost, AbstractResource resourceType, AbstractResource toRefine) {
        super(name, resourceCost, resourceType);
        this.toRefine = toRefine;
    }


    @Override
    public abstract AbstractRefining clone();
}
