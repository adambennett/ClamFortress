package main.models.buildings.abstracts;

import main.interfaces.*;
import main.models.*;
import main.models.managers.*;
import main.models.resources.*;
import main.models.tech.*;
import main.models.tech.eras.*;

import java.util.logging.*;

public abstract class AbstractBuilding {

    private final String name;
    private final Integer resourceCost;
    private final AbstractResource resouceType;
    private Era eraRequired;

    public AbstractBuilding(String name, int resourceCost, AbstractResource resourceType) {
        this.name = name;
        this.eraRequired = TechTree.getHead();
        this.resouceType = resourceType;
        this.resourceCost = resourceCost;
    }

    public void upgrade() {}

    public Boolean demolish() {
        if (this instanceof Golden) {
            Game.getVillage().setCoins(Game.getVillage().getCoins() + ((Golden) this).getGoldAmt());
            OutputManager.addToBot("Received " + ((Golden) this).getGoldAmt() + " Coins upon destruction of " + this.name + "!");
        }

        if (this instanceof Cursed) {
            ((Cursed) this).runCurse();
            OutputManager.addToBot("You have been Cursed upon the destruction of " + this.name + "!");
        }
        return Game.getVillage().getBuildings().remove(this);
    }

    public void setEraRequired(Era era) {
        this.eraRequired = era;
    }

    public Boolean canBuild() {
        if (!(this.eraRequired.isBehind(TechTree.getCurrentEra()) || this.eraRequired.equals(TechTree.getCurrentEra()))) {
            return false;
        }

        if (this.resouceType instanceof ResourceCost) {
            if (!(Game.getVillage().hasEnoughOfResource(this.resouceType, this.resourceCost))) {
                return false;
            }
        } else {
            Logger.getGlobal().warning("Building with non-ResourceCost object as a Resource Cost!");
        }

        if (this instanceof Unique) {
            for (AbstractBuilding b : Game.getVillage().getBuildings()) {
                if (b.getName().equals(this.getName())) {
                    return false;
                }
            }
        }
        return true;
    }

    public String getName() { return name; }

    public Integer getResourceCost() {
        return resourceCost;
    }

    public AbstractResource getResouceType() {
        return resouceType;
    }
}
