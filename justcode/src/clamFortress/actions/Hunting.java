package clamFortress.actions;

import clamFortress.game.*;
import clamFortress.models.Board;

public class Hunting extends AbstractGameAction {

    public Hunting(Game game) {
        this.setValues(game);
        this.actionType = ActionType.HUNTING;
    }

    @Override
    public void update() {

        Board.getAnimalsInRegionOnBoard();
    }
}
