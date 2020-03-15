package clamFortress.actions;

import clamFortress.models.beings.player.*;

public class Building extends AbstractGameAction {

    public Building(Survivor source, int amount) {
        this.setValues(source, amount);
        this.actionType = ActionType.BUILDING;
    }

    @Override
    public void update() {
        // do building logic
    }
}
