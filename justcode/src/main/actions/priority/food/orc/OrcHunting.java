package main.actions.priority.food.orc;

import main.actions.*;

public class OrcHunting extends AbstractGameAction {
    public OrcHunting(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {
        this.isDone = true;
    }

    @Override
    public OrcHunting clone() {
        return new OrcHunting(this.amountToRun);
    }
}
