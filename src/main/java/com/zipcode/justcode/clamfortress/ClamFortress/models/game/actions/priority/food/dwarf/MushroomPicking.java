package com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.priority.food.dwarf;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.*;

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
