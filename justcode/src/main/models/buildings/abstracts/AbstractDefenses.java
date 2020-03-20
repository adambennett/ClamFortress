package main.models.buildings.abstracts;

import main.models.*;
import main.models.managers.*;
import main.models.resources.*;

public abstract class AbstractDefenses extends AbstractBuilding {

    private final Integer defense;

    public AbstractDefenses(String name, int resourceCost, int defend, AbstractResource resourceType) {
        super(name, getDesc(name, resourceCost, defend, resourceType), resourceCost, resourceType);
        this.defense = defend;
    }

    public static String getDesc(String name, int resourceCost, int defend, AbstractResource resourceType) {
        String output = "";
        output += name + " [M][DEF|" + defend + "]-[COST|" + resourceCost + "x" + resourceType.getName() + "]";
        return output;
    }

    @Override
    public void onBuild() {
        super.onBuild();
        Game.getVillage().incDefense(this.defense);
        OutputManager.addToBot("Village Defenses improved by " + this.defense + " due to construction of " + this.getName());
    }

    public Integer getDefense() {
        return defense;
    }

    @Override
    public abstract AbstractDefenses clone();
}
