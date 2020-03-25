package com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.priority.food.human;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers.*;

import java.util.*;
import java.util.concurrent.*;

public class Hunting extends AbstractGameAction {

    public Hunting(int amtToRun) {
        super(amtToRun);
    }

    @Override
    public void update() {
        int animals = 0;
        int animalsOnBoard = Game.getGameBoard().getAnimals().size();
        if (animalsOnBoard > 0) {
            int rando = ThreadLocalRandom.current().nextInt(animalsOnBoard);
            animals += Game.getGameBoard().getAnimals().remove(rando).getAmountOfFoodOnHunt();
        }
        if (animals > 0) {
            for (GameObject obj : Game.getModifierObjects()) {
                animals *= obj.multiplyFoodOnHunting();
            }
            Game.getVillage().incFood(animals);
            OutputManager.addToBot("Hunted " + animals + " new food");
        }
        this.isDone = true;
    }

    @Override
    public Hunting clone() {
        return new Hunting(this.amountToRun);
    }

    public void setSeed() {
        ThreadLocalRandom.current().setSeed(10);
    }
}
