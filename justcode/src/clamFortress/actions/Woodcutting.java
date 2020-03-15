package clamFortress.actions;

import clamFortress.game.Game;
import clamFortress.models.beings.player.*;

public class Woodcutting extends AbstractGameAction {

    private Game game;

    public Woodcutting(Integer amountOfWood, Game game) {
        this.setValues(null, amountOfWood);
        this.game = game;
        this.actionType = ActionType.WOODCUTTING;
    }

    @Override
    public void update(){
    }
}
