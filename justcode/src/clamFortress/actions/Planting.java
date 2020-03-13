package clamFortress.actions;

import clamFortress.models.beings.*;

public class Planting extends AbstractGameAction {

    public Planting(Survivor source, int amount) {
        this.setValues(source, amount);
        this.actionType = ActionType.PLANTING;
    }

    @Override
    public void update() {
        // do building logic
    }
}
