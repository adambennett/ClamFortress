package main.actions.priority.food.claman;

import main.actions.*;

public class Diving extends AbstractGameAction {
    @Override
    public void update() {
        this.isDone = true;
    }

    @Override
    public Diving clone() {
        return new Diving();
    }
}
