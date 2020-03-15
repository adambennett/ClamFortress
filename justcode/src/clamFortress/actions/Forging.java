package clamFortress.actions;

import clamFortress.game.*;
import clamFortress.models.beings.player.*;

public class Forging extends AbstractGameAction {

    public Forging(Game game) {
        this.setValues(game);
        this.actionType = ActionType.FORGING;
    }

    @Override
    public void update() {
        // do building logic
    }
}
