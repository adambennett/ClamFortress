package com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.priority;



import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.enums.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural.*;

import java.util.concurrent.*;

public class Woodcutting extends AbstractGameAction {

    public Woodcutting(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {
        int wood = 0;
        Integer high = Game.getGameBoard().getResource("wood");
        int goldWood = 0;
        if (high != null && high > 0) {
            if (high == 1) { high = 2; }
            wood += ThreadLocalRandom.current().nextInt(1, high);
            wood += Game.getVillage().getStrengthAvg();
            if (Game.getVillage().getInventory().containsItem("golden axe") && high > 12) {
                wood += ThreadLocalRandom.current().nextInt(1, (int) (high/3.0));
                goldWood += ThreadLocalRandom.current().nextInt(0, (int) (high/12.0));
            } else if (Game.getVillage().getInventory().containsItem("axe") && high > 5) {
                wood += ThreadLocalRandom.current().nextInt(1, (int) (high/3.0));
            }

            if (wood > high) {
                wood = high;
            }
            if (goldWood > 0 && Game.getVillage().addResource(new GoldenWood(), goldWood)) {
                OutputManager.addToBot("Chopped " + goldWood + " Golden Wood!");
                GameManager.getInstance().gainExperience(10);
            }
            if (wood > 0 && Game.getVillage().addResource(new Wood(), wood)) {
                Game.getGameBoard().removeResource("wood", wood);
                OutputManager.addToBot("Chopped " + wood + " wood!");
                GameManager.getInstance().gainExperience();
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

