package main.actions.priority;

import main.actions.*;

public class Smelting extends AbstractGameAction {

    @Override
    public void update() {
        this.isDone = true;
    }

    @Override
    public Smelting clone() {
        return new Smelting();
    }
}
