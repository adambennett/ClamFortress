package main.actions.priority.food.human;

import main.actions.*;
import main.models.Game;
import main.models.items.*;
import main.models.items.artifacts.*;
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
        for (AbstractItem spear : Game.getVillage().getInventory().getItems()) {
            animals *= spear.multiplyFoodOnHunting();
        }
        Game.getVillage().incFood(animals);
        OutputManager.addToBot("Hunted " + animals + " new food");
        this.isDone = true;
    }

    @Override
    public Hunting clone() {
        return new Hunting();
    }
}
