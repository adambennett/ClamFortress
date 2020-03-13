package clamFortress.actions;

import clamFortress.models.beings.*;

public class Defense extends AbstractGameAction {

    public Defense(Survivor source, int amount) {
        this.setValues(source, amount);
        this.actionType = ActionType.DEFENDING;
    }

    @Override
    public void update() {
        // do building logic
    }
}
