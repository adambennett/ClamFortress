package main.actions.priority;

import main.actions.*;
import main.models.*;
import main.models.managers.*;
import main.models.resources.natural.*;

import java.util.concurrent.*;

public class Woodcutting extends AbstractGameAction {

    @Override
    public void update() {
        int wood = 15;
        Integer high = Game.getGameBoard().getResource("wood");
        if (high != null && high > 0) {
            wood += ThreadLocalRandom.current().nextInt(0, high);
        }
        wood += Game.getVillage().getStrengthAvg();
        Game.getGameBoard().removeResource("wood", wood);
        if (Game.getVillage().addResource(new Wood(), wood)) {
            OutputManager.addToBot("Chopped " + wood + " wood!");
            GameManager.getInstance().gainExperience();
        }
        this.isDone = true;
    }

    @Override
    public Woodcutting clone() {
        return new Woodcutting();
    }
}

