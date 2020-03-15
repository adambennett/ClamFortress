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
        Integer amountOfWoodToReturn = 0;
     if(currentGame.getGameBoard().getNumberOfTreesOnBoard() > 25){
         if(currentGame.getVillage().getStrengthAvg() > 6){
             if(currentGame.getGameBoard().getNumberOfTreesOnBoard() >50){
                 amountOfWoodToReturn+=50;
             } else{
                 amountOfWoodToReturn += currentGame.getGameBoard().getNumberOfTreesOnBoard();
             }
             currentGame.getGameBoard().reduceTreesOnBoard(50);
         }


     } else{
         amountOfWoodToReturn += currentGame.getGameBoard().getNumberOfTreesOnBoard();
     }


            this.isDone = true;
    }
}

