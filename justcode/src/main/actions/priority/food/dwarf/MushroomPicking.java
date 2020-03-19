package main.actions.priority.food.dwarf;

import main.actions.*;

public class MushroomPicking extends AbstractGameAction {
    public MushroomPicking(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {
        this.isDone = true;
    }

    @Override
    public MushroomPicking clone() {
        return new MushroomPicking(this.amountToRun);
    }
}
