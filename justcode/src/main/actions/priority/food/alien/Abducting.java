package main.actions.priority.food.alien;

import main.actions.*;

public class Abducting extends AbstractGameAction {
    public Abducting(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {
        this.isDone = true;
    }

    @Override
    public Abducting clone() {
        return new Abducting(this.amountToRun);
    }
}
