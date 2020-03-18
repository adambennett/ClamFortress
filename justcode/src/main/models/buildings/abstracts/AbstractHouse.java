package main.models.buildings.abstracts;

import main.models.*;
import main.models.items.*;
import main.models.managers.*;
import main.models.resources.*;

public abstract class AbstractHouse extends AbstractBuilding {

    private final Integer popCapInc;

    public AbstractHouse(String name, int popCapInc, int resourceCost, AbstractResource resourceType) {
        super(name, resourceCost, resourceType);
        this.popCapInc = popCapInc;
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
