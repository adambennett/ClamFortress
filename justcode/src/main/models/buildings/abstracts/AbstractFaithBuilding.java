package main.models.buildings.abstracts;

import main.models.*;
import main.models.managers.*;
import main.models.resources.*;

public abstract class AbstractFaithBuilding extends AbstractBuilding {

    protected Integer prayBonus;
    protected Integer faithCapInc;

    public AbstractFaithBuilding(String name, int resourceCost, int prayBonus, int faithCapInc, AbstractResource resourceType) {
        super(name, resourceCost, resourceType);
        this.prayBonus = prayBonus;
        this.faithCapInc = faithCapInc;
    }


    public Integer getPrayBonus() {
        return prayBonus;
    }

    @Override
    public void onBuild() {
        if (this.faithCapInc > 0) {
            Game.getVillage().setFaithLimit(Game.getVillage().getFaithLimit() + this.faithCapInc);
            OutputManager.addToBot("New Building " + this.getName() + " has been completed! Faith cap has been increased by " + this.faithCapInc);
        } else {
            OutputManager.addToBot("New Building " + this.getName() + " has been completed!");
        }
    }

    @Override
    public abstract AbstractFaithBuilding clone();
}
