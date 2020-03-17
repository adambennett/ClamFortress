package main.actions.priority;

import main.actions.*;
import main.models.Game;
import java.util.Random;

public class Hunting extends AbstractGameAction {

    private Random random;

    public Hunting() {
        this.random = new Random();
    }

    @Override
    public void update() {
        int size = Game.getGameBoard().getAnimals().size();
        if (size > 0) {
            int rando = random.nextInt(size);
            Integer foodToReturn = Game.getGameBoard().getAnimals().get(rando).getAmountOfFoodOnHunt();
            Game.getGameBoard().getAnimals().remove(rando);
            Game.getVillage().incFood(foodToReturn);
        } else {
            Game.getVillage().incFood(1);
        }
        this.isDone = true;
    }
}
