package clamFortress.actions;

import clamFortress.models.beings.*;

public class Foraging extends AbstractGameAction {

    public Foraging(Survivor source, int amount) {
        this.setValues(source, amount);
        this.actionType = ActionType.FORAGING;
    }

    @Override
    public void update() {
        // do building logic
    }
}
