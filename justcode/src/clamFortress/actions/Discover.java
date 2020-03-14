package clamFortress.actions;

import clamFortress.game.regions.*;
import clamFortress.models.beings.*;

public class Discover extends AbstractGameAction {

    private AbstractRegion region;

    public Discover(AbstractRegion region) {
        this.actionType = ActionType.DISCOVER;
        this.region = region;
    }

    @Override
    public void update() {
        // Board.discover(this.region);
        // this.isDone = true;
    }
}
