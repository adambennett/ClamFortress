package main.actions.priority;

import main.actions.*;
import main.enums.*;
import main.models.*;
import main.models.nodes.*;
import main.models.managers.*;

public class Scouting extends AbstractGameAction {

    private final Integer nethermod;

    public Scouting(int amtToRun, int nethermod) {
        super(amtToRun);
        this.nethermod = nethermod;
    }

    @Override
    public void update() {
        if (!Game.getGameBoard().isBoardFull()) {
            AbstractNode region = Game.getGameBoard().getRandomRegion(this.nethermod);
            Game.getGameBoard().discover(region);
            OutputManager.addToBot("Discovered a new " + region.toString() + " region!");
        } else {
            OutputManager.addToBot(OutputFlag.FULL_BOARD, "The board is full! You cannot discover any additional spaces!");
            this.setAmtRemaining(this.amountToRun);
        }
        this.isDone = true;
    }

    @Override
    public Scouting clone() {
        return new Scouting(this.amountToRun, this.nethermod);
    }
}
