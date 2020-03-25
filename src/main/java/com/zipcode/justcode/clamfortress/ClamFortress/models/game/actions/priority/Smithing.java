package com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.priority;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.*;

public class Smithing extends AbstractGameAction {

    public Smithing(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {

        this.isDone = true;
    }

    @Override
    public Smithing clone() {
        return new Smithing(this.amountToRun);
    }
}
