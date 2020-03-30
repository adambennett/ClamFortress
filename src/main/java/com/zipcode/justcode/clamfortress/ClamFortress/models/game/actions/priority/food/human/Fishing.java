package com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.priority.food.human;



import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.other.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

import java.util.*;

public class Fishing extends AbstractGameAction {

    private Random random;

    public Fishing(int amtToRun) {
        super(amtToRun);
        this.random = new Random();
    }

    @Override
    public void update() {
        int fish = 0;
        int fishOnBoard = Database.getCurrentGame().getGameBoard().getSeaAnimals().size();
        if (fishOnBoard > 0) {
            int rando = random.nextInt(fishOnBoard);
            fish += Database.getCurrentGame().getGameBoard().getSeaAnimals().get(rando).getAmountOfFoodOnHunt();
            Database.getCurrentGame().getGameBoard().getSeaAnimals().remove(rando);
        }
        if (fish < 2) {
            fish = 2;
        }
        for (GameObject obj : Database.getCurrentGame().getModifierObjects()) {
            fish *= obj.multiplyFoodOnFishing();
        }

        int fishMod = 1;
        if (Database.getCurrentGame().getVillage().getInventory().containsItem("net")) {
            fishMod++;
        }

        if (Database.getCurrentGame().getVillage().getInventory().containsItem("fishing rod")) {
            fishMod++;
        }

        if (Database.getCurrentGame().getVillage().getInventory().containsItem("fishing spear")) {
            fishMod++;
        }
        fish = fish * fishMod;
        Database.getCurrentGame().getVillage().incFood(fish);
        OutputManager.addToBot("Fished " + fish + " new food");
        this.isDone = true;
    }

    @Override
    public AbstractGameAction clone() {
        return new Fishing(this.amountToRun);
    }
}
