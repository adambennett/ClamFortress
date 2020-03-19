package main.models.buildings.abstracts;

import main.interfaces.*;
import main.models.*;
import main.models.managers.*;
import main.models.resources.*;
import main.models.tech.*;
import main.models.tech.eras.*;

import java.util.logging.*;

public abstract class AbstractBuilding extends GameObject {

    private final Integer resourceCost;
    private final AbstractResource resourceType;
    private Era eraRequired;

    public AbstractBuilding(String name, int resourceCost, AbstractResource resourceType) {
        super(name);
        this.eraRequired = TechTree.getHead();
        this.resourceType = resourceType;
        this.resourceCost = resourceCost;
    }

    public void onBuild() {
        OutputManager.addToBot("New Building " + this.getName() + " has been completed!");
    }

    public void upgrade() {}

    public Boolean demolish() {
        for (GameObject obj : Game.getModifierObjects()) {
            obj.onDemolish();
        }
        if (this instanceof Golden) {
            Game.getVillage().setCoins(Game.getVillage().getCoins() + ((Golden) this).getGoldAmt());
            OutputManager.addToBot("Received " + ((Golden) this).getGoldAmt() + " Coins upon destruction of " + this.getName() + "!");
        }

        if (this instanceof Cursed) {
            ((Cursed) this).runCurse();
            OutputManager.addToBot("You have been Cursed upon the destruction of " + this.getName() + "!");
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

        if (this.resourceType instanceof ResourceCost) {
            if (!(Game.getVillage().hasEnoughOfResource(this.resourceType.getName(), this.resourceCost))) {
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

    public Integer getResourceCost() {
        return resourceCost;
    }

    public AbstractResource getResourceType() {
        return resourceType;
    }

    @Override
    public abstract AbstractBuilding clone();
}
