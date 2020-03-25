package com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.priority.food.orc;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.*;

public class OrcHunting extends AbstractGameAction {
    public OrcHunting(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {
        this.isDone = true;
    }

    @Override
    public OrcHunting clone() {
        return new OrcHunting(this.amountToRun);
    }
}
