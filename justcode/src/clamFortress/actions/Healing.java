package clamFortress.actions;

import clamFortress.models.Board;
import clamFortress.models.beings.*;

public class Healing extends AbstractGameAction {

    public Healing(Survivor source, int amount) {
        this.setValues(source, amount);
        this.actionType = ActionType.HEALING;
    }

    @Override
    public void update() {
        // do building logic
    }

    public static void healSurvivor(Survivor toBeHealed, Survivor healer){
        Integer healAmount = 10;

        if(healer.getIntelligence() > 7/*placeholder number*/){
            healAmount+=10;
        }
        if(Board.getHealingItemsOnBoard() > 0){
            Board.setHealingItemsOnBoard(Board.getHealingItemsOnBoard()-1);
            healAmount+=10;
        }
        toBeHealed.setHealthPoints(toBeHealed.getHealthPoints()+healAmount);

    }
}
