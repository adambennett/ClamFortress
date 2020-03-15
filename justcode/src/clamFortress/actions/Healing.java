package clamFortress.actions;

import clamFortress.game.*;
import clamFortress.models.Board;
import clamFortress.models.beings.player.*;

import java.util.*;

public class Healing extends AbstractGameAction {


    public Healing(Game game) {
        this.currentGame = game;
        this.actionType = ActionType.HEALING;
    }

    @Override
    public void update() {
        // TODO: improve
        /*Integer healAmount = 10;

        if(source.getIntelligence() >= 7/*placeholder number){
            healAmount+=10;
        }
        if(Board.getHealingItemsOnBoard() > 0){
            Board.setHealingItemsOnBoard(Board.getHealingItemsOnBoard()-1);
            healAmount+=10;
        }
        target.setHealthPoints(target.getHealthPoints()+healAmount);
        */
        this.isDone = true;
    }
}
