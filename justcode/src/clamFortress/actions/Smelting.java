package clamFortress.actions;

import clamFortress.game.*;

public class Smelting extends AbstractGameAction {

    public Smelting(Game game) {
        this.setValues(game);
        this.actionType = ActionType.MASONRY;
    }

    @Override
    public void update() {
        // do building logic
        this.isDone = true;
    }
}
