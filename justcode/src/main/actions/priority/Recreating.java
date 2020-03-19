package main.actions.priority;

import main.actions.*;

public class Recreating extends AbstractGameAction {

    public Recreating(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {
        this.isDone = true;
    }

    @Override
    public Recreating clone() {
        return new Recreating(this.amountToRun);
    }
}
