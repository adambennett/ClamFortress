package main.actions.priority.food.elf;

import main.actions.*;

public class InsectHunt extends AbstractGameAction {
    @Override
    public void update() {
        this.isDone = true;
    }

    @Override
    public InsectHunt clone() {
        return new InsectHunt();
    }
}
