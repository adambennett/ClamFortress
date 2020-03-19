package main.actions.priority.food.elf;

import main.actions.*;

public class Roasting extends AbstractGameAction {
    public Roasting(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {
        this.isDone = true;
    }

    @Override
    public Roasting clone() {
        return new Roasting(this.amountToRun);
    }
}
