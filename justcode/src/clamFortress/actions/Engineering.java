package clamFortress.actions;

import clamFortress.models.beings.*;

public class Engineering extends AbstractGameAction {

    public Engineering(Survivor source, int amount) {
        this.setValues(source, amount);
        this.actionType = ActionType.ENGINEERING;
    }

    @Override
    public void update() {
        // do building logic
    }
}
