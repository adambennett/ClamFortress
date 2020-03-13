package clamFortress.actions;

import clamFortress.models.beings.*;

public class Sailing extends AbstractGameAction {

    public Sailing(Survivor source, int amount) {
        this.setValues(source, amount);
        this.actionType = ActionType.SAILING;
    }

    @Override
    public void update() {
        // do building logic
    }
}
