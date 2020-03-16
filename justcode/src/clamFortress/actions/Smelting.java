package clamFortress.actions;

import clamFortress.game.*;

public class Smelting extends AbstractGameAction {

    public Smelting() {
        this.actionType = ActionType.MASONRY;
    }

    @Override
    public void update() {
        this.isDone = true;
    }
}
