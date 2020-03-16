package clamFortress.actions;

import clamFortress.game.*;

public class Sailing extends AbstractGameAction {

    public Sailing() {
        this.actionType = ActionType.SAILING;
    }

    @Override
    public void update() {
        this.isDone = true;
    }
}
