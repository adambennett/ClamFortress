package main.models.buildings.abstracts;

import main.models.resources.*;

public abstract class AbstractRefining extends AbstractBuilding {

    private AbstractResource toRefine;

    public AbstractRefining(String name, int resourceCost, AbstractResource resourceType, AbstractResource toRefine) {
        super(name, getDesc(name, resourceCost, resourceType, toRefine), resourceCost, resourceType);
        this.toRefine = toRefine;
    }

    public AbstractRefining(String name, String desc, int resourceCost, AbstractResource resourceType, AbstractResource toRefine) {
        super(name, desc, resourceCost, resourceType);
        this.toRefine = toRefine;
    }

    public static String getDesc(String name, int resourceCost, AbstractResource resourceType, AbstractResource toRefine) {
        String output = "";
        output += name + " [R][REFINES|" + toRefine.getName() + "]-[COST|" + resourceCost + "x" + resourceType.getName() + "]";
        return output;
    }

    @Override
    public abstract AbstractRefining clone();
}
