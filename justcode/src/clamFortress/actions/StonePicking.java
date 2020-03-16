package clamFortress.actions;

import clamFortress.game.*;

public class StonePicking extends AbstractGameAction {

    public StonePicking(Game game) {
        this.setValues(game);
        this.actionType = ActionType.MASONRY;
    }

    @Override
    public void update() {
        // do building logic
        this.isDone = true;
    }
}
