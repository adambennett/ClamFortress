package main.actions;

import main.game.Game;
import java.util.Random;

public class Hunting extends AbstractGameAction {
Random random = new Random();
    public Hunting() {
        this.actionType = ActionType.HUNTING;
    }

    @Override
    public void update() {
        int rando = random.nextInt( Game.getGameBoard().getAnimals().size());


        Integer foodToReturn = Game.getGameBoard().getAnimals().get(rando).getAmountOfFoodOnHunt();
        Game.getGameBoard().getAnimals().remove(rando);
        Game.getVillage().incFood(foodToReturn);
        this.isDone = true;
    }
}
