package main.models.buildings.abstracts;

import main.models.*;
import main.models.items.*;
import main.models.managers.*;
import main.models.resources.*;

public abstract class AbstractHouse extends AbstractBuilding {

    private final Integer popCapInc;

    public AbstractHouse(String name, int popCapInc, int resourceCost, AbstractResource resourceType) {
        super(name, getDesc(name, popCapInc, resourceCost, resourceType), resourceCost, resourceType);
        this.popCapInc = popCapInc;
    }

    public static String getDesc(String name, int popCapInc, int resourceCost, AbstractResource resourceType) {
        String output = "";
        output += name + " [H][PCAP|" + popCapInc + "]-[COST|" + resourceCost + "x" + resourceType.getName() + "]";
        return output;
    }

    @Override
    public void onBuild() {
        int inc = this.popCapInc;
        for (GameObject obj : Game.getModifierObjects()) {
            inc += obj.modifyPopCapIncreases();
        }
        Game.getVillage().incPopCap(inc);
        OutputManager.addToBot("New Building " + this.getName() + " has been completed! Increased population cap by " + inc + ".");
    }

    public Integer getPopCapInc() {
        return popCapInc;
    }

    @Override
    public abstract AbstractHouse clone();
}
