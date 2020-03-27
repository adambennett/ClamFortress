package com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.priority;



import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.enums.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

import java.util.concurrent.*;

public class RockPicking extends AbstractGameAction {

    public RockPicking(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {
        int rockToReturn = 0;
        Integer rocksOnBoard = Database.getCurrentGame().getGameBoard().getResource("rock");
        if (rocksOnBoard != null && rocksOnBoard > 0) {
            int high = (int) (rocksOnBoard / 3.0);
            if (high < 1) { high = 1; }
            rockToReturn = ThreadLocalRandom.current().nextInt(0, high);
            Integer amt = Database.getCurrentGame().getGameBoard().removeResource("rock", rockToReturn);
            if (amt > 0 && Database.getCurrentGame().getVillage().addResource(new Rock(), amt)) {
                OutputManager.addToBot("Picked " + rockToReturn + " rocks!");
            }
        } else {
            OutputManager.addToBot(OutputFlag.NO_ROCKS, "No more Rocks left on board! Try Scouting more.");
        }
        this.isDone = true;
    }

    @Override
    public RockPicking clone() {
        return new RockPicking(this.amountToRun);
    }
}
