package clamFortress.actions;

import clamFortress.game.*;

public class Harvesting extends AbstractGameAction {

    public Harvesting(Game game) {
        this.setValues(game);
        this.actionType = ActionType.HARVESTING;
    }

    @Override
    public void update() {
        // do building logic
    }


}
