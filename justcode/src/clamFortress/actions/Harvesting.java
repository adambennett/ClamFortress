package clamFortress.actions;

import clamFortress.models.beings.*;

public class Harvesting extends AbstractGameAction {

    public Harvesting(Survivor source, int amount) {
        this.setValues(source, amount);
        this.actionType = ActionType.HARVESTING;
    }

    @Override
    public void update() {
        // do building logic
    }


}
