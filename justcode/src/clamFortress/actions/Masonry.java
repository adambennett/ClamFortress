package clamFortress.actions;

import clamFortress.models.beings.*;

public class Masonry extends AbstractGameAction {

    public Masonry(Survivor source, int amount) {
        this.setValues(source, amount);
        this.actionType = ActionType.MASONRY;
    }

    @Override
    public void update() {
        // do building logic
    }
}
