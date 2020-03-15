package clamFortress.actions;

import clamFortress.game.*;
import clamFortress.models.beings.player.*;

public class Foraging extends AbstractGameAction {

    public Foraging(Game game) {
        this.setValues(game);
        this.actionType = ActionType.FORAGING;
    }

    @Override
    public void update() {
        // do building logic
    }
}
