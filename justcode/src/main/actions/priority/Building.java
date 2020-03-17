package main.actions.priority;

import main.actions.*;

public class Building extends AbstractGameAction {

    @Override
    public void update() {
        this.isDone = true;
    }
}
