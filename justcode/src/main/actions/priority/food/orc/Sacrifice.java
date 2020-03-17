package main.actions.priority.food.orc;

import main.actions.*;

public class Sacrifice extends AbstractGameAction {
    @Override
    public void update() {
        this.isDone = true;
    }
}
