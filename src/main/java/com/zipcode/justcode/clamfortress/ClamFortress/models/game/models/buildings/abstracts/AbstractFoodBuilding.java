package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.*;

public abstract class  AbstractFoodBuilding extends AbstractBuilding {


    public AbstractFoodBuilding(String name, String desc, int resourceCost, AbstractResource resourceType) {
        super(name, desc, resourceCost, resourceType);
    }


    public abstract AbstractFoodBuilding clone();
}
