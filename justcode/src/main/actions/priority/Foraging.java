package main.actions.priority;

import main.actions.*;
import main.models.*;
import main.models.items.*;
import main.models.items.artifacts.*;
import main.models.managers.*;
import main.models.resources.*;

import java.util.*;
import java.util.concurrent.*;

public class Foraging extends AbstractGameAction {

    @Override
    public void update() {
        if (ThreadLocalRandom.current().nextInt(0, 10) > 4) {
            forage();
        } else if (Game.getVillage().getInventory().containsItem(new RingOfForaging().getName())) {
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
    public Forging clone() {
        return new Forging();
    }

    public void forage() {
        if (ThreadLocalRandom.current().nextBoolean()) {
            if (ThreadLocalRandom.current().nextBoolean()) {
                if (ThreadLocalRandom.current().nextBoolean()) {
                    ArrayList<AbstractItem> items = Archive.getInstance().items();
                    AbstractItem item = items.get(ThreadLocalRandom.current().nextInt(items.size()));
                    Game.getVillage().addToInventory(item.getName());
                    OutputManager.addToBot("Found " + item.getName() + " while Foraging");
                    GameManager.getInstance().gainExperience(10);
                    this.isDone = true;
                    return;
                }
            }
        }
        AbstractResource rand = Game.getGameBoard().removeRandomResource();
        if (rand != null) {
            Game.getVillage().addResource(rand);
            GameManager.getInstance().gainExperience();
            OutputManager.addToBot("Found " + rand.getName() + " while Foraging");
        }
        this.isDone = true;
    }
}
