package clamFortress.actions;

import clamFortress.models.Board;
import clamFortress.models.beings.player.*;

public class Healing extends AbstractGameAction {


    public Healing(Survivor source, Survivor target , int amount) {
        this.setValues(source,target, amount);
        this.actionType = ActionType.HEALING;
    }

    @Override
    public void update() {
        Integer healAmount = 10;

        if(source.getIntelligence() >= 7/*placeholder number*/){
            healAmount+=10;
        }
        if(Board.getHealingItemsOnBoard() > 0){
            Board.setHealingItemsOnBoard(Board.getHealingItemsOnBoard()-1);
            healAmount+=10;
        }
        target.setHealthPoints(target.getHealthPoints()+healAmount);
        this.isDone = true;
    }
}
