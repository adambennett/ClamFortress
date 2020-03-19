package main.actions.priority.food.elf;

import main.actions.*;

public class RiverSearch extends AbstractGameAction {
    public RiverSearch(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {
        this.isDone = true;
    }

    @Override
    public RiverSearch clone() {
        return new RiverSearch(this.amountToRun);
    }
}
