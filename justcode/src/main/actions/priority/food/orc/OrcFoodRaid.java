package main.actions.priority.food.orc;

import main.actions.*;

public class OrcFoodRaid extends AbstractGameAction {
    public OrcFoodRaid(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {
        this.isDone = true;
    }

    @Override
    public OrcFoodRaid clone() {
        return new OrcFoodRaid(this.amountToRun);
    }
}
