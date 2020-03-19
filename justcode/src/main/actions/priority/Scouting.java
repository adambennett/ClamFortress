package main.actions.priority;

import main.actions.*;
import main.enums.*;
import main.models.*;
import main.models.nodes.*;
import main.models.managers.*;

public class Scouting extends AbstractGameAction {

    private AbstractNode region;

    public Scouting() {

    }

    @Override
    public void update() {
        this.region = Game.getGameBoard().getRandomRegion();
        if (this.region == null) {
            OutputManager.addToBot(OutputFlag.FULL_BOARD, "The board is full! You cannot discover any additional spaces!");
            this.isDone = true;
            return;
        }
        Game.getGameBoard().discover(region);
        OutputManager.addToBot("Discovered a new " + region.toString() + " region!");
        this.isDone = true;
    }

    @Override
    public Scouting clone() {
        return new Scouting();
    }
}
