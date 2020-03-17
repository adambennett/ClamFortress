package main.actions;

import main.enums.*;
import main.game.*;
import main.game.logic.*;
import main.models.beings.player.*;
import main.models.resources.refined.food.*;

import java.util.concurrent.*;
import java.util.logging.*;

public class EndPhaseHunger extends AbstractGameAction {

    public EndPhaseHunger() {
        this.actionType = ActionType.NEW_SURVIVORS;
    }

    @Override
    public void update() {
        int numHungry = 0;
        int foodAmt = Game.getVillage().getFood();
        for (Survivor s : Game.getVillage().getSurvivors()) {
            if (foodAmt>0) {
                foodAmt--;
                int healAmt = 100;
                if (Game.getDifficulty().compareTo(Difficulty.IMPOSSIBLE) >= 0) {
                    healAmt = 10;
                } else if (Game.getDifficulty().compareTo(Difficulty.NIGHTMARE) >= 0) {
                    healAmt = 15;
                } else if (Game.getDifficulty().compareTo(Difficulty.BRUTAL) >= 0) {
                    healAmt = 25;
                } else if (Game.getDifficulty().compareTo(Difficulty.HARD) >= 0) {
                    healAmt = 40;
                } else if (Game.getDifficulty().compareTo(Difficulty.DEFAULT) >= 0) {
                    healAmt = 50;
                }
                s.feed(new PlaceholderFood(healAmt));
            } else{
                numHungry++;
            }
        }
        if (foodAmt > 0) {
            Game.getVillage().setFamine(Game.getVillage().getFamine() - foodAmt);
        }
        for (int i = 0; i < Game.getVillage().getFamine(); i++) {
            if (Game.getVillage().getSurvivors().size() > 0) {
                int rand = ThreadLocalRandom.current().nextInt(Game.getVillage().getSurvivors().size());
                Survivor s = Game.getVillage().getSurvivors().remove(rand);
                Game.getVillage().updateAfterRemoving(s);
                OutputManager.addToBottom("\n" + s.getName() + " has left your Village due to ongoing famine concerns!");
            }
        }
        double newFamine = numHungry / 4.0;
        if (numHungry > 0 && (int)newFamine < 0) {
            newFamine = 1.0;
        }
        int newHunger = numHungry;
        Game.getVillage().setFamine((int) newFamine);
        Game.getVillage().setHunger(newHunger);
        this.isDone = true;
    }

}
