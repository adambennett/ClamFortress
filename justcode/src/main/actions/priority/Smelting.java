package main.actions.priority;

import main.actions.AbstractGameAction;
import main.interfaces.Smeltable;
import main.models.Game;
import main.models.items.AbstractItem;
import main.models.managers.GameManager;
import main.models.managers.OutputManager;
import main.models.resources.AbstractResource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Smelting extends AbstractGameAction {
    Random random = new Random();
    public Smelting(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {
        HashMap<Smeltable,Integer> smeltables = new HashMap<>();
        ArrayList<Smeltable> smelted= new ArrayList<>();

        int amountToSmelt = 2 + random.nextInt(5);


        // gets all the smeltables out of the inventory
        for (AbstractItem i: Game.getVillage().getInventory().getItems()) {
            if (i instanceof Smeltable) {
                smelted.add((Smeltable) i);
                if (!smeltables.containsKey(i)) {
                    smeltables.put((Smeltable) i, 1);
                } else {
                    smeltables.put((Smeltable) i, smeltables.get(i) + 1);
                }
            }
        }



        while(amountToSmelt > 0 && smelted.size() > 0){
            Smeltable rand = smelted.get(ThreadLocalRandom.current().nextInt(smelted.size()));
            int amount = smeltables.get(rand);
            AbstractResource someName = (AbstractResource) rand;
            Game.getVillage().removeResource( someName.getName());
            Game.getVillage().addResource( rand.getRefined(),amount);
            OutputManager.addToBot("Smelted " + amount + " " + ( rand.getRefined()).getName() + "!");
            GameManager.getInstance().gainExperience();
            amountToSmelt--;
        }
        this.isDone = true;
    }

    @Override
    public Smelting clone() {
        return new Smelting(this.amountToRun);
    }
}
