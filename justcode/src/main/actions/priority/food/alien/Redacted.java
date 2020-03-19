package main.actions.priority.food.alien;

import main.actions.*;

public class Redacted extends AbstractGameAction {
    public Redacted(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {
        this.isDone = true;
    }

    @Override
    public Redacted clone() {
        return new Redacted(this.amountToRun);
    }
}
