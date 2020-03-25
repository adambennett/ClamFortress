package com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.priority;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.*;

public class Demolishing extends AbstractGameAction {

    public Demolishing(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {
        this.isDone = true;

    }

    @Override
    public Demolishing clone() {
        return new Demolishing(this.amountToRun);
    }
}
