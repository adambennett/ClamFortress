package clamFortress.actions;

import clamFortress.game.*;
import clamFortress.models.beings.player.*;

public class Building extends AbstractGameAction {

    public Building() {
        this.actionType = ActionType.BUILDING;
    }

    @Override
    public void update() {
        this.isDone = true;

    }
}
