package main.actions.priority;

import main.actions.*;

public class Searching extends AbstractGameAction {

    @Override
    public void update() {
        this.isDone = true;

    }

    @Override
    public Searching clone() {
        return new Searching();
    }
}
