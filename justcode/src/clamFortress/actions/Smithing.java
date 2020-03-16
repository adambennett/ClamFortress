package clamFortress.actions;

import clamFortress.game.*;

public class Smithing extends AbstractGameAction {

    public Smithing() {
        this.actionType = ActionType.SMITHING;
    }

    @Override
    public void update() {
        this.isDone = true;
    }
}
