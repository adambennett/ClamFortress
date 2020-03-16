package clamFortress.actions;

import clamFortress.game.*;

public class Recreating extends AbstractGameAction {

    public Recreating(Game game) {
        this.setValues(game);
        this.actionType = ActionType.RECREATING;
    }

    @Override
    public void update() {
        // do building logic
        this.isDone = true;
    }
}
