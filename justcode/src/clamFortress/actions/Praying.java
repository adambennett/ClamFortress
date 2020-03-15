package clamFortress.actions;

import clamFortress.models.beings.player.*;

public class Praying extends AbstractGameAction {

    public Praying(Survivor source, int amount) {
        this.setValues(source, amount);
        this.actionType = ActionType.PRAYING;
    }

    @Override
    public void update() {
        // do building logic
    }


}
