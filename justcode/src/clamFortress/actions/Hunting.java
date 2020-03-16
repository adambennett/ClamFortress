package clamFortress.actions;

import clamFortress.game.*;
import clamFortress.models.Board;

public class Hunting extends AbstractGameAction {

    public Hunting() {
        this.actionType = ActionType.HUNTING;
    }

    @Override
    public void update() {
        this.isDone = true;

    }
}
