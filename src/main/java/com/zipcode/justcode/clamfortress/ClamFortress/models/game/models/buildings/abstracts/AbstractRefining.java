package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.*;

public abstract class AbstractRefining extends AbstractBuilding {

    private AbstractResource toRefine;

    public AbstractRefining(String name, int resourceCost, AbstractResource resourceType, AbstractResource toRefine) {
        super(name, getDesc(resourceCost, resourceType, toRefine), resourceCost, resourceType);
        this.toRefine = toRefine;
    }

    public AbstractRefining(String name, String desc, int resourceCost, AbstractResource resourceType, AbstractResource toRefine) {
        super(name, desc, resourceCost, resourceType);
        this.toRefine = toRefine;
    }

    public static String getDesc(int resourceCost, AbstractResource resourceType, AbstractResource toRefine) {
        String output = "";
        output += "[Refines: " + toRefine.getName() + "] - [Cost: " + resourceCost + "x" + resourceType.getName() + "]";
        return output;
    }

    @Override
    public abstract AbstractRefining clone();
}
