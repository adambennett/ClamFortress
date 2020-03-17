package main.actions;

import main.game.Game;
import java.util.Random;

public class Hunting extends AbstractGameAction {

    private Random random = new Random();

    public Hunting() {
        this.actionType = ActionType.HUNTING;
    }

    @Override
    public void update() {

        // hunger doesnt seem to update properly even with simplified logic like this

        Game.getVillage().incFood(1);
        /*int size = Game.getGameBoard().getAnimals().size();
        if (size > 0) {
            int rando = random.nextInt(size);
            Integer foodToReturn = Game.getGameBoard().getAnimals().get(rando).getAmountOfFoodOnHunt();
            Game.getGameBoard().getAnimals().remove(rando);
            Game.getVillage().incFood(foodToReturn);
        } else {
            Game.getVillage().incFood(1);
        }*/
        this.isDone = true;
    }
}
