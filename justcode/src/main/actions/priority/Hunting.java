package main.actions.priority;

import main.actions.*;
import main.models.Game;
import main.models.artifacts.*;
import main.models.managers.*;

import java.util.Random;

public class Hunting extends AbstractGameAction {

    private Random random;

    public Hunting() {
        this.random = new Random();
    }

    @Override
    public void update() {
        int animals = 0;
        int animalsOnBoard = Game.getGameBoard().getAnimals().size();
        if (animalsOnBoard > 0) {
            int rando = random.nextInt(animalsOnBoard);
            animals += Game.getGameBoard().getAnimals().remove(rando).getAmountOfFoodOnHunt();
        }
        if (animals < 2) {
            animals = 2;
        }
        for (AbstractArtifact spear : Game.getVillage().getArtifacts()) {
            animals *= spear.multiplyFoodOnHunting();
        }
        Game.getVillage().incFood(animals);
        OutputManager.addToBottom("Hunted " + animals + " new food");
        this.isDone = true;
    }
}
