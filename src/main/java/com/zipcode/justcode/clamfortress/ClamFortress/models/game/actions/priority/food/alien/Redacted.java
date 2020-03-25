package com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.priority.food.alien;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.*;

public class Redacted extends AbstractGameAction {
    public Redacted(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {
        this.isDone = true;
    }

    @Override
    public Redacted clone() {
        return new Redacted(this.amountToRun);
    }
}
