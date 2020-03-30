package com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.priority.food.human;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.other.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

import java.util.concurrent.*;

public class Hunting extends AbstractGameAction {

    public Hunting(int amtToRun) {
        super(amtToRun);
    }

    @Override
    public void update() {
        int animals = 0;
        int animalsOnBoard = Database.getCurrentGame().getGameBoard().getAnimals().size();
        if (animalsOnBoard > 0) {
            int rando = ThreadLocalRandom.current().nextInt(animalsOnBoard);
            animals += Database.getCurrentGame().getGameBoard().getAnimals().remove(rando).getAmountOfFoodOnHunt();
        }
        if (animals > 0) {
            for (GameObject obj : Database.getCurrentGame().getModifierObjects()) {
                animals *= obj.multiplyFoodOnHunting();
            }
            Database.getCurrentGame().getVillage().incFood(animals);
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
