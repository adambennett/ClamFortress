package main.actions.priority;

import main.actions.*;

public class StonePicking extends AbstractGameAction {

    @Override
    public void update() {
        Integer stoneToReturn = 15;
        this.isDone = true;
    }
}
