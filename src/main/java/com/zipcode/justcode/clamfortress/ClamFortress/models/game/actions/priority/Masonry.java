package com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.priority;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers.*;

public class Masonry extends AbstractGameAction {

    public Masonry(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {
        Game.getVillage().setBuildingLimit(Game.getVillage().getBuildingLimit() + 1);
        GameManager.getInstance().gainExperience();
        this.isDone = true;
    }

    @Override
    public Masonry clone() {
        return new Masonry(this.amountToRun);
    }
}
