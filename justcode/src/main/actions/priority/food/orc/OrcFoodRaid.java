package main.actions.priority.food.orc;

import main.actions.*;

public class OrcFoodRaid extends AbstractGameAction {
    @Override
    public void update() {
        this.isDone = true;
    }

    @Override
    public OrcFoodRaid clone() {
        return new OrcFoodRaid();
    }
}
