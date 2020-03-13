package clamFortress.actions;

import clamFortress.models.beings.*;

public class Scouting extends AbstractGameAction {

    public Scouting(Survivor source, int amount) {
        this.setValues(source, amount);
        this.actionType = ActionType.SCOUTING;
    }

    @Override
    public void update() {
        // do building logic
    }
}
