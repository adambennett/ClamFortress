package clamFortress.actions;

import clamFortress.game.*;

public class Defense extends AbstractGameAction {

    public Defense() {
        this.actionType = ActionType.DEFENDING;
    }

    @Override
    public void update() {
        Integer defense = Game.getVillage().getDefense();
        while (defense >4){
            Game.getVillage().reduceBandits();
            defense-=5;
        }
        this.isDone = true;
    }
}