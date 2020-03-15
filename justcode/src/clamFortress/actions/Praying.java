package clamFortress.actions;

import clamFortress.game.*;

public class Praying extends AbstractGameAction {

    public Praying(Game game) {
        this.setValues(game);
        this.actionType = ActionType.PRAYING;
    }

    @Override
    public void update() {
        // do building logic
    }


}
