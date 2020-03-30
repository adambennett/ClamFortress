package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.other.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.tech.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.tech.eras.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

import java.util.*;
import java.util.logging.*;


public abstract class AbstractBuilding extends GameObject {

    private Integer resourceCost;


    private AbstractResource resourceType;

    private Era eraRequired;

    public AbstractBuilding(String name, String desc, int resourceCost, AbstractResource resourceType) {
        super(name, desc);
        this.eraRequired = TechTree.getHead();
        this.resourceType = resourceType;
        this.resourceCost = resourceCost;
    }

    public void onBuild() {
        OutputManager.addToBot("New Building " + this.getName() + " has been completed!");
    }

    public void upgrade() {}

    public Integer demolish() {
        for (GameObject obj : Database.getCurrentGame().getModifierObjects()) {
            obj.onDemolish();
        }
        if (this instanceof Golden) {
            Database.getCurrentGame().getVillage().incCoins(((Golden) this).getGoldAmt());
            OutputManager.addToBot("Received " + ((Golden) this).getGoldAmt() + " Coins upon destruction of " + this.getName() + "!");
        }

        if (this instanceof Cursed) {
            ((Cursed) this).runCurse();
            OutputManager.addToBot("You have been Cursed upon the destruction of " + this.getName() + "!");
        }
        return Database.getCurrentGame().getVillage().getBuildings().remove(this);
    }

    public void setEraRequired(Era era) {
        this.eraRequired = era;
    }

    public Boolean canBuild() {
        if (TechTree.getCurrentEra().isBehind(this.eraRequired)) {
            return false;
        }

        if (this.resourceType instanceof ResourceCost) {
            if (!(Database.getCurrentGame().getVillage().hasEnoughOfResource(this.resourceType.getName(), this.resourceCost))) {
                return false;
            }
        } else {
            Logger.getGlobal().warning("Building with non-ResourceCost object as a Resource Cost!");
        }

        if (this instanceof Unique) {
            for (Map.Entry<AbstractBuilding, Integer> b : Database.getCurrentGame().getVillage().getBuildings().entrySet()) {
                if (b.getKey().getName().equals(this.getName())) {
                    return false;
                }
            }
        }
        return true;
    }

    public String getBuildingType() {
        if (this instanceof AbstractDefenses) {
            return "Military";
        } else if (this instanceof AbstractFaithBuilding) {
            return "Religious";
        } else if (this instanceof AbstractHouse) {
            return "Housing";
        } else if (this instanceof AbstractRefining) {
            return "Refinement";
        } else if (this instanceof AbstractStorehouse) {
            return "Storing";
        }
        return "General Purpose";
    }

    public Integer getResourceCost() {
        return resourceCost;
    }

    public AbstractResource getResourceType() {
        return resourceType;
    }

    public void setResourceCost(Integer resourceCost) {
        this.resourceCost = resourceCost;
    }

    public void setResourceType(AbstractResource resourceType) {
        this.resourceType = resourceType;
    }

    public Era getEraRequired() {
        return eraRequired;
    }



    @Override
    public abstract AbstractBuilding clone();
}
