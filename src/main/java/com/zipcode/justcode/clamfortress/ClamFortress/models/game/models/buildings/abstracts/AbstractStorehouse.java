package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.*;

public abstract class AbstractStorehouse extends AbstractBuilding {

    private final Integer storageCapacityIncrease;

    public AbstractStorehouse(String name, int resourceCost, int storageInc, AbstractResource resourceType) {
        super(name, getDesc(name, resourceCost, storageInc, resourceType), resourceCost, resourceType);
        this.storageCapacityIncrease = storageInc;
    }

    public static String getDesc(String name, int resourceCost, int storageInc, AbstractResource resourceType) {
        String output = "";
        output += name + " [S][RCAP|" + storageInc + "]-[COST|" + resourceCost + "x" + resourceType.getName() + "]";
        return output;
    }

    @Override
    public void onBuild() {
        int inc = this.storageCapacityIncrease;
        for (GameObject obj : Game.getModifierObjects()) {
            inc += obj.modifyResourceStorageIncreases();
        }
        Game.getVillage().setResourceLimit(Game.getVillage().getResourceLimit() + inc);
        Game.getVillage().setFoodLimit((int) (Game.getVillage().getFoodLimit() + inc / 4.0));
        OutputManager.addToBot("New Building " + this.getName() + " has been completed! Increased resource cap by " + inc + ".");
    }

    public Integer getStorageCapacityIncrease() {
        return storageCapacityIncrease;
    }

    @Override
    public abstract AbstractStorehouse clone();
}
