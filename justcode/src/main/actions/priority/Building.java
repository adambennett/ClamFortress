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

    private Integer popCapInc;
    private AbstractBuilding newBuilding;
    private boolean built = false;
    private int inc = 0;

    public Building(AbstractBuilding building) {
        if (building instanceof AbstractHouse) {
            this.popCapInc = ((AbstractHouse) building).getPopCapInc();
        } else {
            this.popCapInc = 0;
        }
        this.newBuilding = building;
    }

    @Override
    public void update() {
        if (built) {
            onCompletion(inc);
            this.isDone = true;
            return;
        }

        if (this.newBuilding.canBuild()) {
            if (this.newBuilding instanceof AbstractHouse) {
                AbstractHouse house = (AbstractHouse)this.newBuilding;
                this.inc = this.popCapInc;
                for (AbstractItem art : Game.getVillage().getInventory().getItems()) {
                    this.inc += art.modifyPopCapIncreases();
                }
                Game.getVillage().incPopCap(this.inc);
            }
            this.built = Game.getVillage().addBuilding(this.newBuilding);
            if (!this.built) {
                this.isDone = true;
                OutputManager.addToBot("Building Project " + this.newBuilding.getName() + " has been halted because you have reached the current Building Limit", OutputFlag.BUILDING_HALT);
            }
        } else {
            OutputManager.addToBot("Cannot build " + this.newBuilding.getName() + " - Not Advanced Enough", OutputFlag.ERA_BEHIND);
            this.isDone = true;
        }
    }

    @Override
    public Building clone() {
        return new Building(this.newBuilding);
    }

    public void onCompletion(int inc) {
        Game.getVillage().getUncompletedBuildings().remove(this.newBuilding);
        if (this.newBuilding instanceof AbstractHouse) {
            int diff = inc - ((AbstractHouse) this.newBuilding).getPopCapInc();
            if (diff > 0) {
                OutputManager.addToBot("New Building " + this.newBuilding.getName() + " increased population cap by " + ((AbstractHouse) this.newBuilding).getPopCapInc() + "(+" + diff + ")");
            } else {
                OutputManager.addToBot("New Building " + this.newBuilding.getName() + " increased population cap by " + inc);
            }
        } else {
            OutputManager.addToBot("New Building " + this.newBuilding.getName() + " has been completed!");
        }
    }
}
