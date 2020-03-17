package main.actions.priority.food.dwarf;

import main.actions.*;

public class MushroomPicking extends AbstractGameAction {
    @Override
    public void update() {
        this.isDone = true;
    }

    @Override
    public MushroomPicking clone() {
        return new MushroomPicking();
    }
}
