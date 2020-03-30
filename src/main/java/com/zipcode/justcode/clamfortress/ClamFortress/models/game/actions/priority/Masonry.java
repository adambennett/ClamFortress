package com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.priority;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.enums.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

public class Masonry extends AbstractGameAction {

    public Masonry(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {
        if (Database.getCurrentGame().getVillage().getResource("brick") != null && Database.getCurrentGame().getVillage().getResource("brick") > 0) {
            Database.getCurrentGame().getVillage().removeResource("brick", 1);
            Database.getCurrentGame().getVillage().setBuildingLimit(Database.getCurrentGame().getVillage().getBuildingLimit() + 1);
            Database.getCurrentGame().gameManager.gainExperience();
            OutputManager.addToBot("Masonry: Consumed 1 brick and improved building limit by 1");
        } else {
            OutputManager.addToBot(OutputFlag.BRICK_HALT, "Masonry: No brick remaining!");
            this.setAmtRemaining(this.amountToRun);
        }
        this.isDone = true;
    }

    @Override
    public Masonry clone() {
        return new Masonry(this.amountToRun);
    }
}
