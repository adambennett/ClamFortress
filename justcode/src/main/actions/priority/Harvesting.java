package main.actions.priority;

import main.actions.*;

public class Harvesting extends AbstractGameAction {

    @Override
    public void update() {
        this.isDone = true;

    }

    @Override
    public Harvesting clone() {
        return new Harvesting();
    }


}
