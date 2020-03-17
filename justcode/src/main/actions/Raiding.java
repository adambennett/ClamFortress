package main.actions;

import main.models.gridSpaces.CitySpace;

public class Raiding extends AbstractGameAction {

    public Raiding(CitySpace citySpace) {
        this.actionType = ActionType.RAIDING;
    }

    @Override
    public void update() {
        this.isDone = true;
    }
}
