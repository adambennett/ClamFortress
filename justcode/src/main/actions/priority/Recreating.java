package main.actions.priority;

import main.actions.*;

public class Recreating extends AbstractGameAction {

    @Override
    public void update() {
        this.isDone = true;
    }

    @Override
    public Recreating clone() {
        return new Recreating();
    }
}
