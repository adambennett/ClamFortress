package main.actions.priority;

import main.actions.*;

public class Demolishing extends AbstractGameAction {

    public Demolishing(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {
        this.isDone = true;

    }

    @Override
    public Demolishing clone() {
        return new Demolishing(this.amountToRun);
    }
}
