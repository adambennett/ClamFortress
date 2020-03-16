package clamFortress.actions;

import clamFortress.game.*;
import clamFortress.models.tools.gathering.Pickaxe;

public class StonePicking extends AbstractGameAction {


    public StonePicking() {
        this.actionType = ActionType.MASONRY;
    }

    @Override
    public void update() {
        Integer stoneToReturn = 15;
        this.isDone = true;
    }
}
