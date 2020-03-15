package clamFortress.actions;

import clamFortress.game.*;

public class Defense extends AbstractGameAction {

    public Defense(Game game) {

        this.actionType = ActionType.DEFENDING;
    }

    @Override
    public void update() {
        // do building logic
    }
}
