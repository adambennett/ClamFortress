package main.actions.priority.food.orc;

import main.actions.*;

public class Sacrifice extends AbstractGameAction {
    public Sacrifice(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {
        this.isDone = true;
    }

    @Override
    public Sacrifice clone() {
        return new Sacrifice(this.amountToRun);
    }
}
