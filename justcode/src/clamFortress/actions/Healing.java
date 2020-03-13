package clamFortress.actions;

import clamFortress.models.beings.*;

public class Healing extends AbstractGameAction {

    public Healing(Survivor source, int amount) {
        this.setValues(source, amount);
        this.actionType = ActionType.HEALING;
    }

    @Override
    public void update() {
        // do building logic
    }
}
