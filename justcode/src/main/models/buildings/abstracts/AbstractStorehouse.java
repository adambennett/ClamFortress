package main.models.buildings.abstracts;

import main.models.resources.*;

public abstract class AbstractStorehouse extends AbstractBuilding {

    private final Integer storageCapacityIncrease;

    public AbstractStorehouse(String name, int resourceCost, int storageInc, AbstractResource resourceType) {
        super(name, resourceCost, resourceType);
        this.storageCapacityIncrease = storageInc;
    }

    public Integer getStorageCapacityIncrease() {
        return storageCapacityIncrease;
    }
}
