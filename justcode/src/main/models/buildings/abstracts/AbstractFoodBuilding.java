package main.models.buildings.abstracts;

import main.models.resources.AbstractResource;

public abstract class  AbstractFoodBuilding extends AbstractBuilding {


    public AbstractFoodBuilding(String name, String desc, int resourceCost, AbstractResource resourceType) {
        super(name, desc, resourceCost, resourceType);
    }


    public abstract AbstractFoodBuilding clone();
}
