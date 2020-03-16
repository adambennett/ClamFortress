package clamFortress.actions;

import clamFortress.game.*;

public class Trading extends AbstractGameAction {

    public Trading() {
        this.actionType = ActionType.TRADING;
    }

    @Override
    public void update() {
        this.isDone = true;
    }
}
