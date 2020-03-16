package clamFortress.actions;

import clamFortress.game.regions.*;
import clamFortress.models.beings.*;

public class Scouting extends AbstractGameAction {

    private AbstractRegion region;

    public Scouting(AbstractRegion region) {
        this.actionType = ActionType.DISCOVER;
        this.region = region;
    }

    @Override
    public void update() {
        this.isDone = true;
    }
}
