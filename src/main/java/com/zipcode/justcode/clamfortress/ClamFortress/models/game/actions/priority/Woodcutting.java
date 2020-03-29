package com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.priority;



import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.enums.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

import java.util.concurrent.*;

public class Woodcutting extends AbstractGameAction {

    public Woodcutting(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {
        int wood = 0;
        Integer high = Database.getCurrentGame().getGameBoard().getResource("wood");
        int goldWood = 0;
        if (high != null && high > 0) {
            if (high == 1) { high = 2; }
            wood += ThreadLocalRandom.current().nextInt(1, high);
            wood += Database.getCurrentGame().getVillage().getStrengthAvg();
            if (Database.getCurrentGame().getVillage().getInventory().containsItem("golden axe") && high > 12) {
                wood += ThreadLocalRandom.current().nextInt(1, (int) (high/3.0));
                goldWood += ThreadLocalRandom.current().nextInt(0, (int) (high/12.0));
            } else if (Database.getCurrentGame().getVillage().getInventory().containsItem("axe") && high > 5) {
                wood += ThreadLocalRandom.current().nextInt(1, (int) (high/3.0));
            }

            if (wood > high) {
                wood = high;
            }
            if (goldWood > 0 && Database.getCurrentGame().getVillage().addResource(new GoldenWood(), goldWood)) {
                OutputManager.addToBot("Chopped " + goldWood + " Golden Wood!");
                Database.getCurrentGame().gameManager.gainExperience(10);
            }
            if (wood > 0 && Database.getCurrentGame().getVillage().addResource(new Wood(), wood)) {
                Database.getCurrentGame().getGameBoard().removeResource("wood", wood);
                OutputManager.addToBot("Chopped " + wood + " wood!");
                Database.getCurrentGame().gameManager.gainExperience();
            }
        } else {
            OutputManager.addToBot(OutputFlag.NO_WOOD, "No more Wood left on board! Try Scouting more.");
        }
        this.isDone = true;
    }

    @Override
    public Woodcutting clone() {
        return new Woodcutting(this.amountToRun);
    }
}

