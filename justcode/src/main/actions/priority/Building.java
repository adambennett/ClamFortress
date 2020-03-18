package main.actions.priority;

import main.actions.*;
import main.enums.*;
import main.models.*;
import main.models.items.*;
import main.models.items.artifacts.*;
import main.models.buildings.abstracts.*;
import main.models.managers.*;

import java.util.logging.*;

public class Building extends AbstractGameAction {

    private AbstractBuilding newBuilding;

    public Building(AbstractBuilding building) {
        this.newBuilding = building;
    }

    @Override
    public void update() {
        if (this.newBuilding.canBuild()) {
            if (Game.getVillage().addBuilding(this.newBuilding)) {
                Game.getVillage().getUncompletedBuildings().remove(this.newBuilding);
                this.newBuilding.onBuild();
            } else {
                OutputManager.addToBot("Building Project " + this.newBuilding.getName() + " has been halted because you have reached the current Building Limit", OutputFlag.BUILDING_HALT);
            }
        } else {
            OutputManager.addToBot("Cannot build " + this.newBuilding.getName());
            this.isDone = true;
        }
    }

    @Override
    public Building clone() {
        return new Building(this.newBuilding);
    }
}
