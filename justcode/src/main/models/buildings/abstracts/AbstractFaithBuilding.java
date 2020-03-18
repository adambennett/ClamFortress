package main.models.buildings.abstracts;

import main.models.resources.*;

public abstract class AbstractFaithBuilding extends AbstractBuilding {

    protected Integer prayBonus;

    public AbstractFaithBuilding(String name, int resourceCost, int prayBonus, AbstractResource resourceType) {
        super(name, resourceCost, resourceType);
        this.prayBonus = prayBonus;
    }


    public Integer getPrayBonus() {
        return prayBonus;
    }
}
