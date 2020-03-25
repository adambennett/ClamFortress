package com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.priority.food.human;



import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers.*;

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
        int fishOnBoard = Game.getGameBoard().getSeaAnimals().size();
        if (fishOnBoard > 0) {
            int rando = random.nextInt(fishOnBoard);
            fish += Game.getGameBoard().getSeaAnimals().get(rando).getAmountOfFoodOnHunt();
            Game.getGameBoard().getSeaAnimals().remove(rando);
        }
        if (fish < 2) {
            fish = 2;
        }
        for (GameObject obj : Game.getModifierObjects()) {
            fish *= obj.multiplyFoodOnFishing();
        }

        int fishMod = 1;
        if (Game.getVillage().getInventory().containsItem("net")) {
            fishMod++;
        }

        if (Game.getVillage().getInventory().containsItem("fishing rod")) {
            fishMod++;
        }

        if (Game.getVillage().getInventory().containsItem("fishing spear")) {
            fishMod++;
        }
        fish = fish * fishMod;
        Game.getVillage().incFood(fish);
        OutputManager.addToBot("Fished " + fish + " new food");
        this.isDone = true;
    }

    @Override
    public AbstractGameAction clone() {
        return new Fishing(this.amountToRun);
    }
}
