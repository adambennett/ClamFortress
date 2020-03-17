package main.actions.priority;

import main.actions.*;
import main.models.*;
import main.models.buildings.abstracts.*;
import main.models.managers.*;

public class Engineering extends AbstractGameAction {

    private AbstractBuilding newBuilding;

    public Engineering(AbstractBuilding building) {
        this.newBuilding = building;
    }

    @Override
    public void update() {
        Game.getVillage().addUncompletedBuilding(this.newBuilding);
        OutputManager.addToBot("Added new " + this.newBuilding.getName() + " Project to Building Queue");
        this.isDone = true;
    }

    @Override
    public Engineering clone() {
        return new Engineering(newBuilding);
    }
}
