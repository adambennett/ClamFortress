package clamFortress.actions;

import clamFortress.game.*;
public class Masonry extends AbstractGameAction {

    public Masonry(Game game) {
        this.setValues(game);
        this.actionType = ActionType.MASONRY;
    }

    @Override
    public void update() {
        // do building logic
    }
}
