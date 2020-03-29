package com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.priority;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.enums.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.tech.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.tech.eras.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

import java.util.*;
import java.util.concurrent.*;

public class Mining extends AbstractGameAction {

    public Mining(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {
        ArrayList<AbstractResource> mined = new ArrayList<>();
        for (AbstractResource ore : ores()) {
            Integer amtOnBoard = Database.getCurrentGame().getGameBoard().getResource(ore.getName());
            if (amtOnBoard != null && amtOnBoard > 0) {
                int roll = ThreadLocalRandom.current().nextInt(0, amtOnBoard);
                if (Database.getCurrentGame().getVillage().getInventory().containsItem("pickaxe")) {
                    roll += ThreadLocalRandom.current().nextInt(0, amtOnBoard);
                }
                if (roll > amtOnBoard) { roll = amtOnBoard; }
                for (int i = 0; i < roll; i++) {
                    mined.add(ore.clone());
                }
                if (roll > 0) {
                    OutputManager.addToBot("Mined " + roll + " " + ore.getName() + "!");
                }
            }
        }
        if (mined.size() > 0) {
            Database.getCurrentGame().gameManager.gainExperience();
            if (!(Database.getCurrentGame().getVillage().addResources(mined))) {
                for (AbstractResource ore : mined) {
                    if (!Database.getCurrentGame().getVillage().addResource(ore)) {
                        OutputManager.addToBot(OutputFlag.RESOURCES_FULL, "Not enough room to accumulate more resources! Build some storehouses.");
                        this.isDone = true;
                        return;
                    }
                }
            }
        } else {
            OutputManager.addToBot(OutputFlag.NO_ROCKS_MINED, "Couldn't find anything to mine. Try Scouting more of the board.");
        }
        this.isDone = true;
    }

    @Override
    public Mining clone() {
        return new Mining(this.amountToRun);
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
            if (Database.getCurrentGame().getVillage().getInventory().containsItem("pickaxe")) {
                typesToMine.add(new Gold());
            }
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
