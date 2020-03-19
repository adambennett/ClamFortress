package main.actions.priority;

import main.actions.*;

public class Forging extends AbstractGameAction {

    public Forging(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {
        this.isDone = true;
    }

    @Override
    public Forging clone() {
        return new Forging(this.amountToRun);
    }
}
