package clamFortress.actions;

import clamFortress.game.*;
import clamFortress.models.beings.player.*;

public class Building extends AbstractGameAction {

    public Building(Game game) {
        this.setValues(game);
        this.actionType = ActionType.BUILDING;
    }

    @Override
    public void update() {
        // do building logic
        this.isDone = true;

    }
}
