package main.actions.priority;

import main.actions.*;

public class Sailing extends AbstractGameAction {

    @Override
    public void update() {
        this.isDone = true;
    }

    @Override
    public Sailing clone() {
        return new Sailing();
    }
}
