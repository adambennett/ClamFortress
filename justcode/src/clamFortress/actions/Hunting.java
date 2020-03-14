package clamFortress.actions;

import clamFortress.models.Board;
import clamFortress.models.beings.*;

public class Hunting extends AbstractGameAction {

    public Hunting(Survivor source, int amount) {
        this.setValues(source, amount);
        this.actionType = ActionType.HUNTING;
    }

    @Override
    public void update() {

        Board.getAnimalsInRegionOnBoard();
    }
}
