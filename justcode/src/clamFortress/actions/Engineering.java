package clamFortress.actions;

import clamFortress.game.*;
import clamFortress.models.beings.player.*;

public class Engineering extends AbstractGameAction {

    public Engineering(Game game) {
        this.setValues(game);
        this.actionType = ActionType.ENGINEERING;
    }

    @Override
    public void update() {
        this.isDone = true;

    }
}
