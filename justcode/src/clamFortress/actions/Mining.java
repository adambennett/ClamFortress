package clamFortress.actions;

import clamFortress.game.*;
import clamFortress.tech.eras.BronzeAge;

public class Mining extends AbstractGameAction {

    public Mining(Game game) {
        this.setValues(game);
        this.actionType = ActionType.MASONRY;
    }

    @Override
    public void update() {
        if(Game.getVillage().getCurrentEra() instanceof BronzeAge){
            //do mining shit
        }
        this.isDone = true;
    }


}
