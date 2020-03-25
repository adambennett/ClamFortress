package com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.priority.food.dwarf;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.*;

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
