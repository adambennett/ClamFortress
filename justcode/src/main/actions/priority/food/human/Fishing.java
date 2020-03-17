package main.actions.priority.food.human;

import main.actions.*;
import main.models.Game;
import main.models.items.artifacts.*;
import main.models.managers.*;

import java.util.Random;

public class Fishing extends AbstractGameAction {

    private Random random;

    public Fishing() { this.random = new Random(); }

    @Override
    public void update() {
        int fish = 0;
        int fishOnBoard = Game.getGameBoard().getFish().size();
        if (fishOnBoard > 0) {
            int rando = random.nextInt(fishOnBoard);
            fish += Game.getGameBoard().getFish().get(rando).getAmountOfFoodOnHunt();
            Game.getGameBoard().getFish().remove(rando);
        }
        if (fish < 2) {
            fish = 2;
        }
        for (AbstractArtifact rod : Game.getVillage().getInventory().getArtifacts()) {
            fish *= rod.multiplyFoodOnFishing();
        }
        Game.getVillage().incFood(fish);
        OutputManager.addToBot("Fished " + fish + " new food");
        this.isDone = true;
    }
}
