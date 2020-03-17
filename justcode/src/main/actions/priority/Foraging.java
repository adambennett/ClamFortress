package main.actions.priority;

import main.actions.*;

public class Foraging extends AbstractGameAction {

    @Override
    public void update() {
        this.isDone = true;

    }

    @Override
    public Foraging clone() {
        return new Foraging();
    }
}
