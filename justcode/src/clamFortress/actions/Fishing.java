package clamFortress.actions;

import clamFortress.game.*;
import clamFortress.models.beings.player.*;

public class Fishing extends AbstractGameAction {

    public Fishing(Game game) {
        this.setValues(game);
        this.actionType = ActionType.FISHING;
    }

    @Override
    public void update() {
        // do building logic
    }
}
