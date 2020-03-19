package main.actions.priority;

import main.actions.*;
import main.enums.*;
import main.models.*;
import main.models.buildings.abstracts.*;
import main.models.managers.*;

public class Building extends AbstractGameAction {

    public Building(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {
        if (Game.getVillage().getUncompletedBuildings().size() < 1) {
            this.isDone = true;
            return;
        }
        AbstractBuilding newBuilding = Game.getVillage().getUncompletedBuildings().remove(0);
        if (newBuilding.canBuild()) {
            if (Game.getVillage().addBuilding(newBuilding)) {
                newBuilding.onBuild();
                GameManager.getInstance().gainExperience();
            } else {
                Game.getVillage().getUncompletedBuildings().add(newBuilding);
                OutputManager.addToBot(OutputFlag.BUILDING_HALT, "Building Project " + newBuilding.getName() + " has been halted because you have reached the current Building Limit");
            }
        } else {
            Game.getVillage().getUncompletedBuildings().add(newBuilding);
            OutputManager.addToBot("Cannot build " + newBuilding.getName());
            this.isDone = true;
        }
    }

    @Override
    public Building clone() {
        return new Building(this.amountToRun);
    }
}
