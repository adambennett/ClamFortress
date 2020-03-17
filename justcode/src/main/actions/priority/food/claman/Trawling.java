package main.actions.priority.food.claman;

import main.actions.*;

public class Trawling extends AbstractGameAction {
    @Override
    public void update() {
        this.isDone = true;
    }

    @Override
    public Trawling clone() {
        return new Trawling();
    }
}
