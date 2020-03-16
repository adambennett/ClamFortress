package clamFortress.actions;

import clamFortress.game.*;
import clamFortress.tech.*;
import clamFortress.tech.eras.BronzeAge;

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
