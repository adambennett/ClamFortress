package main.actions.priority.food.elf;

import main.actions.*;

public class Roasting extends AbstractGameAction {
    @Override
    public void update() {
        this.isDone = true;
    }
}
