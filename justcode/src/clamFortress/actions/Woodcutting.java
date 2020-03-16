package clamFortress.actions;

import clamFortress.game.*;

public class Woodcutting extends AbstractGameAction {

    public Woodcutting(Game game) {
        this.setValues(game);
        this.actionType = ActionType.WOODCUTTING;
    }

    @Override
    public void update() {
        Integer amountOfWoodToReturn = 15;
     if(currentGame.getGameBoard().getTrees() > 25){
         if(currentGame.getVillage().getStrengthAvg() > 6){
             if(currentGame.getGameBoard().getTrees() >50){
                 amountOfWoodToReturn+=50;
             } else{
                 amountOfWoodToReturn += currentGame.getGameBoard().getTrees();
             }
             currentGame.getGameBoard().reduceTreesOnBoard(50);
         }


     } else{
         amountOfWoodToReturn += currentGame.getGameBoard().getTrees();
     }

        currentGame.getVillage().incWood(amountOfWoodToReturn);

        this.isDone = true;
    }
}

