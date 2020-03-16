package clamFortress.actions;

import clamFortress.game.*;

public class Trading extends AbstractGameAction {

    public Trading(Game game) {
        this.setValues(game);
        this.actionType = ActionType.TRADING;
    }

    @Override
    public void update() {
        this.isDone = true;
    }
}
