package main.actions.priority.food.claman;

import main.actions.*;

public class Angling extends AbstractGameAction {
    @Override
    public void update() {
        this.isDone = true;
    }

    @Override
    public Angling clone() {
        return new Angling();
    }
}
