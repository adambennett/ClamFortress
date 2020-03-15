package clamFortress.actions;

import clamFortress.models.beings.player.*;

public class Fishing extends AbstractGameAction {

    public Fishing(Survivor source, int amount) {
        this.setValues(source, amount);
        this.actionType = ActionType.FISHING;
    }

    @Override
    public void update() {
        // do building logic
    }
}
