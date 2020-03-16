package clamFortress.actions;

import clamFortress.game.*;
import clamFortress.models.beings.player.*;

public class Foraging extends AbstractGameAction {

    public Foraging() {
        this.actionType = ActionType.FORAGING;
    }

    @Override
    public void update() {
        this.isDone = true;

    }
}
