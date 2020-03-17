package main.actions.priority;

import main.actions.*;

public class Planting extends AbstractGameAction {

    @Override
    public void update() {
        this.isDone = true;
    }
}
