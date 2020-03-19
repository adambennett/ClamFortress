package main.actions.priority.food.dwarf;

import main.actions.*;

public class Brewing extends AbstractGameAction {
    public Brewing(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {
        this.isDone = true;
    }

    @Override
    public Brewing clone() {
        return new Brewing(this.amountToRun);
    }
}
