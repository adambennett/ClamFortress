package main.actions.priority.food.alien;

import main.actions.*;

public class Abducting extends AbstractGameAction {
    @Override
    public void update() {
        this.isDone = true;
    }
}
