package com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.priority;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

public class Engineering extends AbstractGameAction {

    public Engineering(int amtToRun) {
        super(amtToRun);
    }

    @Override
    public void update() {
        AbstractBuilding newBuilding = BuildingManager.getRandomBuilding();
        Database.getCurrentGame().getVillage().addUncompletedBuilding(newBuilding);
        OutputManager.addToBot("Added new " + newBuilding.getName() + " Project to Building Queue");
        if (Database.getCurrentGame().getVillage().getInventory().containsItem("hammer")) {
            GameManager.getInstance().gainExperience(10);
        }
        this.isDone = true;
    }

    @Override
    public Engineering clone() {
        return new Engineering(this.amountToRun);
    }
}
