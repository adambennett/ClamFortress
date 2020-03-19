package main.actions.priority.food.human;

import main.actions.*;

public class Cooking extends AbstractGameAction {
    public Cooking(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {
        this.isDone = true;
    }

    @Override
    public AbstractGameAction clone() {
        return new Cooking(this.amountToRun);
    }
}
