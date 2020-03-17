package main.actions.priority;

import main.actions.*;

public class Fishing extends AbstractGameAction {

    @Override
    public void update() {
        this.isDone = true;
    }
}
