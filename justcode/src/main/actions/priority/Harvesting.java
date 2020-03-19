package main.actions.priority;

import main.actions.*;

public class Harvesting extends AbstractGameAction {

    public Harvesting(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {
        this.isDone = true;

    }

    @Override
    public Harvesting clone() {
        return new Harvesting(this.amountToRun);
    }


}
