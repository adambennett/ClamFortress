package com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.priority.food.alien;

import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.*;

public class Abducting extends AbstractGameAction {
    public Abducting(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {
        this.isDone = true;
    }

    @Override
    public Abducting clone() {
        return new Abducting(this.amountToRun);
    }
}
