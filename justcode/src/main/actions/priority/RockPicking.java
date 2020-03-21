package main.actions.priority;

import main.actions.*;
import main.enums.*;
import main.models.Game;
import main.models.managers.*;
import main.models.resources.natural.*;

import java.util.concurrent.*;

public class RockPicking extends AbstractGameAction {

    public RockPicking(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {
        int rockToReturn = 0;
        Integer rocksOnBoard = Game.getGameBoard().getResource("rock");
        if (rocksOnBoard != null && rocksOnBoard > 0) {
            int high = (int) (rocksOnBoard / 3.0);
            if (high < 1) { high = 1; }
            rockToReturn = ThreadLocalRandom.current().nextInt(0, high);
            Integer amt = Game.getGameBoard().removeResource("rock", rockToReturn);
            if (amt > 0 && Game.getVillage().addResource(new Rock(), amt)) {
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
