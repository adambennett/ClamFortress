package clamFortress.actions;

import clamFortress.game.*;

public class Harvesting extends AbstractGameAction {

    public Harvesting() {
        this.actionType = ActionType.HARVESTING;
    }

    @Override
    public void update() {
        this.isDone = true;

    }


}
