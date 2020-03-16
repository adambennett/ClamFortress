package clamFortress.actions;

import clamFortress.game.*;
public class Mining extends AbstractGameAction {

    public Mining(Game game) {
        this.setValues(game);
        this.actionType = ActionType.MASONRY;
    }

    @Override
    public void update() {
        this.isDone = true;
    }
}
