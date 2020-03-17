package main.actions.priority;

import main.actions.*;
import main.enums.*;
import main.models.*;
import main.models.artifacts.*;
import main.models.buildings.abstracts.*;
import main.models.managers.*;

public class Building extends AbstractGameAction {

    private Integer popCapInc;
    private AbstractBuilding newBuilding;

    public Building(AbstractBuilding building) {
        this.popCapInc = building.getPopCapInc();
        this.newBuilding = building;
    }

    @Override
    public void update() {
        if (this.newBuilding.canBuild()) {
            int inc = this.popCapInc;
            for (AbstractArtifact art : Game.getVillage().getArtifacts()) {
                inc += art.modifyPopCapIncreases();
            }
            Game.getVillage().incPopCap(inc);
            boolean built = Game.getVillage().addBuilding(this.newBuilding);
            if (built) {
                Game.getVillage().getUncompletedBuildings().remove(this.newBuilding);
                int diff = inc - this.newBuilding.getPopCapInc();
                if (diff > 0) {
                    OutputManager.addToBot("New Building " + this.newBuilding.getName() + " increased population cap by " + this.newBuilding.getPopCapInc() + "(+" + diff + ")");
                } else {
                    OutputManager.addToBot("New Building " + this.newBuilding.getName() + " increased population cap by " + inc);
                }
            } else {
                OutputManager.addToBot("Building Project " + this.newBuilding.getName() + " has been halted because you have reached the current Building Limit", OutputFlag.BUILDING_HALT);
            }
        } else {
            OutputManager.addToBot("Cannot build " + this.newBuilding.getName() + " because your current Era is behind the requirements.", OutputFlag.ERA_BEHIND);
        }
        this.isDone = true;
    }
}
