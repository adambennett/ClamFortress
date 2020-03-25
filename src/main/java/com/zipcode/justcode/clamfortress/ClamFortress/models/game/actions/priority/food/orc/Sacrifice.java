package com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.priority.food.orc;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.*;

public class Sacrifice extends AbstractGameAction {
    public Sacrifice(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {
        this.isDone = true;
    }

    @Override
    public Sacrifice clone() {
        return new Sacrifice(this.amountToRun);
    }
}
