package clamFortress.actions;

import clamFortress.game.*;
import clamFortress.models.beings.player.*;

public class Forging extends AbstractGameAction {

    public Forging() {
        this.actionType = ActionType.FORGING;
    }

    @Override
    public void update() {
        this.isDone = true;

    }
}
