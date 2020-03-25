package com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.priority.food.claman;

import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.*;

public class Angling extends AbstractGameAction {
    public Angling(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {
        this.isDone = true;
    }

    @Override
    public Angling clone() {
        return new Angling(this.amountToRun);
    }
}
