package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.*;

public abstract class AbstractFaithBuilding extends AbstractBuilding {

    protected Integer prayBonus;
    protected Integer faithCapInc;

    public AbstractFaithBuilding(String name, int resourceCost, int prayBonus, int faithCapInc, AbstractResource resourceType) {
        super(name, getDesc(name, resourceCost, prayBonus, faithCapInc, resourceType), resourceCost, resourceType);
        this.prayBonus = prayBonus;
        this.faithCapInc = faithCapInc;
    }

    public static String getDesc(String name, int resourceCost, int prayBonus, int faithCapInc, AbstractResource resourceType) {
        String output = "";
        output += name + " [C][PBUFF|" + prayBonus + "]-[FCAP|" + faithCapInc + "]-[COST|" + resourceCost + "x" + resourceType.getName() + "]";
        return output;
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
