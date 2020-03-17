package main.actions.priority.food.human;

import main.actions.*;

public class Cooking extends AbstractGameAction {
    @Override
    public void update() {
        this.isDone = true;
    }

    @Override
    public AbstractGameAction clone() {
        return new Cooking();
    }
}
