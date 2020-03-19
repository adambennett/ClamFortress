package main.actions.priority.food.human;

import main.actions.*;
import main.models.*;
import main.models.items.*;
import main.models.items.artifacts.*;
import main.models.managers.*;

import java.util.Random;

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
        Game.getVillage().incFood(fish);
        OutputManager.addToBot("Fished " + fish + " new food");
        this.isDone = true;
    }

    @Override
    public AbstractGameAction clone() {
        return new Fishing(this.amountToRun);
    }
}
