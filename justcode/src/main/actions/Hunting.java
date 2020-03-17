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
        Integer rando = random.nextInt( Game.getGameBoard().getAnimals().size());
        Integer foodToReturn = 0;

        Game.getGameBoard().getAnimals();

        this.isDone = true;
    }
}
