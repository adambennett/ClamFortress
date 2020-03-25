package com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.priority.food.alien;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.*;

public class Analyzing extends AbstractGameAction {


    public Analyzing(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {
        this.isDone = true;
    }

    @Override
    public Analyzing clone() {
        return new Analyzing(this.amountToRun);
    }
}
