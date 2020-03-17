package main.actions;

import main.tech.*;
import main.tech.eras.BronzeAge;

public class Mining extends AbstractGameAction {

    public Mining() {
        this.actionType = ActionType.MASONRY;
    }

    @Override
    public void update() {
        if(TechTree.getCurrentEra() instanceof BronzeAge){

        }
        this.isDone = true;
    }


}
