package clamFortress.actions;

import clamFortress.game.*;

public class Raiding extends AbstractGameAction {

    public Raiding(Game game) {
        this.setValues(game);
        this.actionType = ActionType.RAIDING;
    }

    @Override
    public void update() {
        // do building logic
    }
}
