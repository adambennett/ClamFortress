package clamFortress.actions;

import clamFortress.game.*;

public class Defense extends AbstractGameAction {

    public Defense(Game game) {
        this.currentGame = game;
        this.actionType = ActionType.DEFENDING;
    }

    @Override
    public void update() {
        Integer defense = currentGame.getVillage().getDefense();
        while (defense >4){
            currentGame.getVillage().reduceBandits();
            defense-=5;
        }
        this.isDone = true;
    }
}