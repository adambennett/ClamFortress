package main.actions.priority;

import main.actions.*;
import main.models.*;
import main.models.nodes.*;
import main.models.managers.*;

public class Scouting extends AbstractGameAction {

    private AbstractNode region;

    public Scouting() {
        this.region = Game.getGameBoard().getRandomRegion();
    }

    @Override
    public void update() {
        boolean discovered = Game.getGameBoard().discover(region);
        if (discovered) {
            OutputManager.addToBottom("Discovered a new " + region.toString() + " region!");
            isDone = true;
        } else {
            region = Game.getGameBoard().getRandomRegion();
        }
    }
}
