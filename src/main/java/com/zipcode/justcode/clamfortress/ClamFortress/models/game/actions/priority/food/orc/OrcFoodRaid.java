package com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.priority.food.orc;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.*;

public class OrcFoodRaid extends AbstractGameAction {
    public OrcFoodRaid(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {
        this.isDone = true;
    }

    @Override
    public OrcFoodRaid clone() {
        return new OrcFoodRaid(this.amountToRun);
    }
}
