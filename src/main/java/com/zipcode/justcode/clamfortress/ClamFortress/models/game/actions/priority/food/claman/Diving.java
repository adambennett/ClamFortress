package com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.priority.food.claman;

import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.*;

public class Diving extends AbstractGameAction {
    public Diving(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {
        this.isDone = true;
    }

    @Override
    public Diving clone() {
        return new Diving(this.amountToRun);
    }
}
