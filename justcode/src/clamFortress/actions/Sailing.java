package clamFortress.actions;

import clamFortress.game.*;

public class Sailing extends AbstractGameAction {

    public Sailing(Game game) {
        this.setValues(game);
        this.actionType = ActionType.SAILING;
    }

    @Override
    public void update() {
        // do building logic
    }
}
