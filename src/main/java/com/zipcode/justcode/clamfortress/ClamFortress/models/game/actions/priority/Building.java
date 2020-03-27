package com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.priority;

import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.enums.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

public class Building extends AbstractGameAction {

    public Building(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {
        if (Database.getCurrentGame().getVillage().getUncompletedBuildings().size() < 1) {
            this.isDone = true;
            return;
        }
        AbstractBuilding newBuilding = Database.getCurrentGame().getVillage().getUncompletedBuildings().remove(0);
        if (newBuilding.canBuild()) {
            if (!GameUtils.obtainBuilding(newBuilding)) {
                Database.getCurrentGame().getVillage().getUncompletedBuildings().add(newBuilding);
                OutputManager.addToBot(OutputFlag.BUILDING_HALT, "Building Project " + newBuilding.getName() + " has been halted because you have reached the current Building Limit");
                this.isDone =true;
            }
        } else {
            Database.getCurrentGame().getVillage().getUncompletedBuildings().add(newBuilding);
            //OutputManager.addToBot("Cannot build " + newBuilding.getName());
            this.isDone = true;
        }
    }

    @Override
    public Building clone() {
        return new Building(this.amountToRun);
    }
}
