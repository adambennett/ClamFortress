package main.actions.priority;

import main.actions.*;
import main.enums.*;
import main.models.*;
import main.models.managers.*;
import main.models.resources.natural.*;

import java.util.concurrent.*;

public class Woodcutting extends AbstractGameAction {

    public Woodcutting(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {
        int wood = 0;
        Integer high = Game.getGameBoard().getResource("wood");
        if (high != null && high > 0) {
            if (high == 1) { high = 2; }
            wood += ThreadLocalRandom.current().nextInt(1, high);
            wood += Game.getVillage().getStrengthAvg();
            if (Game.getVillage().getInventory().containsItem("axe")) {
                wood += ThreadLocalRandom.current().nextInt(1, (int) (high/3.0));;
            }

            if (wood > high) {
                wood = high;
            }
            Game.getGameBoard().removeResource("wood", wood);
            if (Game.getVillage().addResource(new Wood(), wood)) {
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

