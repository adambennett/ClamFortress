package main.actions.priority.food.elf;

import main.actions.*;

public class RiverSearch extends AbstractGameAction {
    @Override
    public void update() {
        this.isDone = true;
    }

    @Override
    public RiverSearch clone() {
        return new RiverSearch();
    }
}
