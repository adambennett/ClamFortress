package com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.priority;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.artifacts.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

import java.util.*;
import java.util.concurrent.*;

public class Foraging extends AbstractGameAction {

    public Foraging(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {
        if (ThreadLocalRandom.current().nextInt(0, 10) > 4) {
            forage();
        } else if (Database.getCurrentGame().getVillage().getInventory().containsItem(new RingOfForaging().getName())) {
            int secondRoll = ThreadLocalRandom.current().nextInt(0, 10);
            if (secondRoll > 2) {
                forage();
            }
        } else {
            OutputManager.addToBot("Found nothing while Foraging.");
        }
        this.isDone = true;
    }

    @Override
    public Foraging clone() {
        return new Foraging(this.amountToRun);
    }

    public void forage() {
        if (ThreadLocalRandom.current().nextBoolean()) {
            if (ThreadLocalRandom.current().nextBoolean()) {
                if (ThreadLocalRandom.current().nextBoolean()) {
                    ArrayList<AbstractItem> items = Archive.getInstance().items();
                    AbstractItem item = items.get(ThreadLocalRandom.current().nextInt(items.size()));
                    Database.getCurrentGame().getVillage().addToInventory(item.getName());
                    OutputManager.addToBot("Found " + item.getName() + " while Foraging");
                    GameManager.getInstance().gainExperience(10);
                    this.isDone = true;
                    return;
                }
            }
        }
        AbstractResource rand = Database.getCurrentGame().getGameBoard().removeRandomResource();
        if (rand != null) {
            Database.getCurrentGame().getVillage().addResource(rand);
            GameManager.getInstance().gainExperience(1);
            OutputManager.addToBot("Found " + rand.getName() + " while Foraging");
        }
        this.isDone = true;
    }
}
