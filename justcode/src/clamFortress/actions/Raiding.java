package clamFortress.actions;

import clamFortress.game.*;
import clamFortress.models.gridSpaces.CitySpace;

public class Raiding extends AbstractGameAction {

    public Raiding(CitySpace citySpace) {
        this.actionType = ActionType.RAIDING;
    }

    @Override
    public void update() {
        this.isDone = true;
    }
}
