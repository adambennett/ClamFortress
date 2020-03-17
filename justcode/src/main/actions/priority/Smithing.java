package main.actions.priority;

import main.actions.*;

public class Smithing extends AbstractGameAction {

    @Override
    public void update() {
        this.isDone = true;
    }
}
