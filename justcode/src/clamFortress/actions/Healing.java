package clamFortress.actions;

import clamFortress.models.Board;
import clamFortress.models.beings.*;

public class Healing extends AbstractGameAction {


    public Healing(Survivor source,Survivor target ,int amount) {
        this.setValues(source,target, amount);
        this.actionType = ActionType.HEALING;
    }

    @Override
    public void update() {
        // do building logic
    }

    public void healSurvivor( Survivor healer,Survivor toBeHealed){
        Integer healAmount = 10;

        if(healer.getIntelligence() >= 7/*placeholder number*/){
            healAmount+=10;
        }
        if(Board.getHealingItemsOnBoard() > 0){
            Board.setHealingItemsOnBoard(Board.getHealingItemsOnBoard()-1);
            healAmount+=10;
        }
        toBeHealed.setHealthPoints(toBeHealed.getHealthPoints()+healAmount);

    }
}
