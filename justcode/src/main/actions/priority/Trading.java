package main.actions.priority;

import main.actions.*;

public class Trading extends AbstractGameAction {

    @Override
    public void update() {
        this.isDone = true;
    }
}
