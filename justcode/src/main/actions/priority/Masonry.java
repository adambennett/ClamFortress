package main.actions.priority;

import main.actions.*;
import main.models.*;

public class Masonry extends AbstractGameAction {

    @Override
    public void update() {
        Game.getVillage().setBuildingLimit(Game.getVillage().getBuildingLimit() + 1);
        this.isDone = true;
    }

    @Override
    public Masonry clone() {
        return new Masonry();
    }
}
