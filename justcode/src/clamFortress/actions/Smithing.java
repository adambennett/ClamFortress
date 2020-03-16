package clamFortress.actions;

import clamFortress.game.*;

public class Smithing extends AbstractGameAction {

    public Smithing(Game game) {
        this.setValues(game);
        this.actionType = ActionType.SMITHING;
    }

    @Override
    public void update() {
        // do building logic
        this.isDone = true;
    }
}
