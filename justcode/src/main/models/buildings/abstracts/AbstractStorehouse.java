package main.models.buildings.abstracts;

import main.models.*;
import main.models.items.*;
import main.models.managers.*;
import main.models.resources.*;

public abstract class AbstractStorehouse extends AbstractBuilding {

    private final Integer storageCapacityIncrease;

    public AbstractStorehouse(String name, int resourceCost, int storageInc, AbstractResource resourceType) {
        super(name, resourceCost, resourceType);
        this.storageCapacityIncrease = storageInc;
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
