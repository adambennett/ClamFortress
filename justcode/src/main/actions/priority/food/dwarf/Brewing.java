package main.actions.priority.food.dwarf;

import main.actions.*;

public class Brewing extends AbstractGameAction {
    @Override
    public void update() {
        this.isDone = true;
    }

    @Override
    public Brewing clone() {
        return new Brewing();
    }
}
