package clamFortress.actions;

import clamFortress.models.beings.player.*;

public class Smithing extends AbstractGameAction {

    public Smithing(Survivor source, int amount) {
        this.setValues(source, amount);
        this.actionType = ActionType.SMITHING;
    }

    @Override
    public void update() {
        // do building logic
    }
}
