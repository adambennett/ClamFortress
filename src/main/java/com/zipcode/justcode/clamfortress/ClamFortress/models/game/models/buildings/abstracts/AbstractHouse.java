package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.other.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

public abstract class AbstractHouse extends AbstractBuilding {

    private final Integer popCapInc;

    public AbstractHouse(String name, int popCapInc, int resourceCost, AbstractResource resourceType) {
        super(name, getDesc(popCapInc, resourceCost, resourceType), resourceCost, resourceType);
        this.popCapInc = popCapInc;
    }

    public static String getDesc(int popCapInc, int resourceCost, AbstractResource resourceType) {
        String output = "";
        output += "[Population Cap Increase: " + popCapInc + "] - [Cost: " + resourceCost + "x" + resourceType.getName() + "]";
        return output;
    }

    @Override
    public void onBuild() {
        int inc = this.popCapInc;
        for (GameObject obj : Database.getCurrentGame().getModifierObjects()) {
            inc += obj.modifyPopCapIncreases();
        }
        Database.getCurrentGame().getVillage().incPopCap(inc);
        OutputManager.addToBot("New Building " + this.getName() + " has been completed! Increased population cap by " + inc + ".");
    }

    public Integer getPopCapInc() {
        return popCapInc;
    }

    @Override
    public abstract AbstractHouse clone();
}
