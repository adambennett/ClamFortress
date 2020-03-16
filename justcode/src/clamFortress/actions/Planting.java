package clamFortress.actions;

import clamFortress.game.*;

public class Planting extends AbstractGameAction {

    public Planting(Game game) {
        this.setValues(game);
        this.actionType = ActionType.PLANTING;
    }

    @Override
    public void update() {
        this.isDone = true;
    }
}
