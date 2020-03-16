package clamFortress.actions;

import clamFortress.game.*;

public class Recreating extends AbstractGameAction {

    public Recreating() {
        this.actionType = ActionType.RECREATING;
    }

    @Override
    public void update() {
        this.isDone = true;
    }
}
