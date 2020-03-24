package main.actions.priority;

import main.actions.*;

public class Storing extends AbstractGameAction {


    public Storing(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {
        this.isDone = true;
    }

    @Override
    public Storing clone() {
        return new Storing(this.amountToRun);
    }
}
