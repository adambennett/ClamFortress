package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.other.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

public abstract class AbstractStorehouse extends AbstractBuilding {

    private final Integer storageCapacityIncrease;

    public AbstractStorehouse(String name, int resourceCost, int storageInc, AbstractResource resourceType) {
        super(name, getDesc(resourceCost, storageInc, resourceType), resourceCost, resourceType);
        this.storageCapacityIncrease = storageInc;
    }

    public static String getDesc(int resourceCost, int storageInc, AbstractResource resourceType) {
        String output = "";
        output +="[Resource Cap Increase: " + storageInc + "] - [Cost: " + resourceCost + "x" + resourceType.getName() + "]";
        return output;
    }

    @Override
    public void onBuild() {
        int inc = this.storageCapacityIncrease;
        for (GameObject obj : Database.getCurrentGame().getModifierObjects()) {
            inc += obj.modifyResourceStorageIncreases();
        }
        Database.getCurrentGame().getVillage().setResourceLimit(Database.getCurrentGame().getVillage().getResourceLimit() + inc);
        Database.getCurrentGame().getVillage().setFoodLimit((int) (Database.getCurrentGame().getVillage().getFoodLimit() + inc / 4.0));
        OutputManager.addToBot("New Building " + this.getName() + " has been completed! Increased resource cap by " + inc + ".");
    }

    public Integer getStorageCapacityIncrease() {
        return storageCapacityIncrease;
    }

    @Override
    public abstract AbstractStorehouse clone();
}
