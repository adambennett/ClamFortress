package main.actions.priority;

import main.actions.*;
import main.models.*;
import main.models.managers.*;

public class Masonry extends AbstractGameAction {

    public Masonry(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {
        Game.getVillage().setBuildingLimit(Game.getVillage().getBuildingLimit() + 1);
        GameManager.getInstance().gainExperience();
        this.isDone = true;
    }

    @Override
    public Masonry clone() {
        return new Masonry(this.amountToRun);
    }
}
