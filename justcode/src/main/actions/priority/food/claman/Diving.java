package main.actions.priority.food.claman;

import main.actions.*;

public class Diving extends AbstractGameAction {
    public Diving(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {
        this.isDone = true;
    }

    @Override
    public Diving clone() {
        return new Diving(this.amountToRun);
    }
}
