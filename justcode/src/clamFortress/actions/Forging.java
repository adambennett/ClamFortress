package clamFortress.actions;

import clamFortress.models.beings.*;

public class Forging extends AbstractGameAction {

    public Forging(Survivor source, int amount) {
        this.setValues(source, amount);
        this.actionType = ActionType.FORGING;
    }

    @Override
    public void update() {
        // do building logic
    }
}
