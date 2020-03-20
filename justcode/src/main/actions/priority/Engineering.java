package main.actions.priority;

import main.actions.*;
import main.models.*;
import main.models.buildings.abstracts.*;
import main.models.managers.*;

public class Engineering extends AbstractGameAction {

    public Engineering(int amtToRun) {
        super(amtToRun);
    }

    @Override
    public void update() {
        AbstractBuilding newBuilding = BuildingManager.getRandomBuilding();
        Game.getVillage().addUncompletedBuilding(newBuilding);
        OutputManager.addToBot("Added new " + newBuilding.getName() + " Project to Building Queue");
        if (Game.getVillage().getInventory().containsItem("hammer")) {
            GameManager.getInstance().gainExperience(10);
        }
        this.isDone = true;
    }

    @Override
    public Engineering clone() {
        return new Engineering(this.amountToRun);
    }
}
