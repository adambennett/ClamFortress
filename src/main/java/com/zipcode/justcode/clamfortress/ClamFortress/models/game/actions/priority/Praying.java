package com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.priority;



import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.other.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

import java.util.*;
import java.util.concurrent.*;

public class Praying extends AbstractGameAction {

    public Praying(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {
        int faithBuildingMod = 0;
        for (Map.Entry<AbstractBuilding, Integer> b : Database.getCurrentGame().getVillage().getBuildings().entrySet()) {
            if (b.getKey() instanceof AbstractFaithBuilding) {
                faithBuildingMod += ((AbstractFaithBuilding) b.getKey()).getPrayBonus() * b.getValue();
            }
        }
        if (faithBuildingMod < 1) {
            faithBuildingMod = 1;
        }

        for (GameObject obj : Database.getCurrentGame().getModifierObjects()) {
            faithBuildingMod += obj.modifyFaithInc();
        }

        int amt = ThreadLocalRandom.current().nextInt(faithBuildingMod+1);
        if (amt > 0) {
            Database.getCurrentGame().getVillage().incFaith(amt);
            Database.getCurrentGame().gameManager.gainExperience();
            OutputManager.addToBot("Praying has earned you " + faithBuildingMod + " Faith");
        }
        this.isDone = true;
    }

    @Override
    public Praying clone() {
        return new Praying(this.amountToRun);
    }


}
