package clamFortress.actions;

import clamFortress.game.*;
import clamFortress.models.*;
import clamFortress.models.beings.player.*;

public class Woodcutting extends AbstractGameAction {

    public Woodcutting(Game game) {
        this.setValues(game);
        this.actionType = ActionType.WOODCUTTING;
    }

    @Override
    public void update() {
     if(currentGame.getGameBoard().getNumberOfTreesOnBoard() > 0){

     }
            this.isDone = true;
        }
}

