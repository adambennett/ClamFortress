package clamFortress.actions;

import clamFortress.game.*;
import clamFortress.models.beings.player.*;

public class Fishing extends AbstractGameAction {

    public Fishing() {
        this.actionType = ActionType.FISHING;
    }

    @Override
    public void update() {
        this.isDone = true;
    }
}
