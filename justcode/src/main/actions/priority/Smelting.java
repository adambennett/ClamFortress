package main.actions.priority;

import main.actions.*;

public class Smelting extends AbstractGameAction {

    public Smelting(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {
        this.isDone = true;
    }

    @Override
    public Smelting clone() {
        return new Smelting(this.amountToRun);
    }
}
