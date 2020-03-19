package main.actions.priority;

import main.actions.*;
import main.enums.*;
import main.models.*;
import main.models.managers.*;
import main.models.resources.*;
import main.models.resources.natural.*;
import main.models.tech.*;
import main.models.tech.eras.*;

import java.util.*;
import java.util.concurrent.*;

public class Mining extends AbstractGameAction {

    @Override
    public void update() {
        ArrayList<AbstractResource> mined = new ArrayList<>();
        for (AbstractResource ore : ores()) {
            int amtOnBoard = Game.getGameBoard().getResource(ore.getName());
            if (amtOnBoard < 1) {
                break;
            }
            int roll = ThreadLocalRandom.current().nextInt(0, amtOnBoard);
            for (int i = 0; i < roll; i++) {
                mined.add(ore.clone());

            }
            OutputManager.addToBot("Mined " + roll + " " + ore.getName() + "!");
        }
        if (!(Game.getVillage().addResources(mined))) {
            for (AbstractResource ore : mined) {
                Game.getVillage().addResource(ore);
            }
        }
        if (mined.size() < 1) {
            OutputManager.addToBot(OutputFlag.NO_ROCKS_MINED, "Couldn't find anything to mine. Try Scouting more of the board.");
        }
        this.isDone = true;
    }

    @Override
    public Mining clone() {
        return new Mining();
    }

    public ArrayList<AbstractResource> ores() {
        Era curr = TechTree.getCurrentEra();
        ArrayList<AbstractResource> typesToMine = new ArrayList<>();
        if (curr.atLeast(new FutureAge())) {
            typesToMine.add(new Spacegoo());
            typesToMine.add(new Gold());
            typesToMine.add(new Iron());
            typesToMine.add(new Copper());
            typesToMine.add(new Rock());
        } else if (curr.atLeast(new ExplorationAge())) {
            typesToMine.add(new Gold());
            typesToMine.add(new Clay());
            typesToMine.add(new Iron());
            typesToMine.add(new Copper());
            typesToMine.add(new Rock());
        } else if (curr.atLeast(new IronAge())) {
            typesToMine.add(new Iron());
            typesToMine.add(new Copper());
            typesToMine.add(new Rock());
        } else if (curr.atLeast(new BronzeAge())) {
            typesToMine.add(new Copper());
            typesToMine.add(new Rock());
        } else if (curr.atLeast(new StoneAge())) {
            typesToMine.add(new Rock());
        }
        return typesToMine;
    }

}
