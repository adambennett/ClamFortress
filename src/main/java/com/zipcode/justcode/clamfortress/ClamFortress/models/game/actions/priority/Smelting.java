package com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.priority;



import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

import java.util.*;
import java.util.concurrent.*;

public class Smelting extends AbstractGameAction {
    Random random = new Random();
    public Smelting(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {
        HashMap<Smeltable,Integer> smeltables = new HashMap<>();
        ArrayList<Smeltable> smelted= new ArrayList<>();
        ArrayList<AbstractResource> recources = Database.getCurrentGame().getVillage().getAllResources();
        int amountToSmelt = 2 + random.nextInt(5);


        // gets all the smeltables out of the inventory
        for (AbstractResource i: recources) {
            if (i instanceof Smeltable) {
                smelted.add((Smeltable) i);
                smeltables.compute((Smeltable)i, new Mapper<Smeltable>(1).mapper);
            }
        }

        while(amountToSmelt > 0 && smelted.size() > 0){
            Smeltable rand = smelted.get(ThreadLocalRandom.current().nextInt(smelted.size()));
            int amount = smeltables.get(rand);
            AbstractResource someName = (AbstractResource) rand;
            Database.getCurrentGame().getVillage().removeResource(someName.getName());
            Database.getCurrentGame().getVillage().addResource(rand.getRefined(),amount);
            OutputManager.addToBot("Smelted " + amount + " " + ( rand.getRefined()).getName() + "!");
            Database.getCurrentGame().gameManager.gainExperience();
            amountToSmelt--;
        }
        this.isDone = true;
    }

    @Override
    public Smelting clone() {
        return new Smelting(this.amountToRun);
    }
}
