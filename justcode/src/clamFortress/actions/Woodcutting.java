package clamFortress.actions;

import clamFortress.game.*;

public class Woodcutting extends AbstractGameAction {

    public Woodcutting() {
        this.actionType = ActionType.WOODCUTTING;
    }

    @Override
    public void update() {
        Integer amountOfWoodToReturn = 15;
        if(Game.getGameBoard().getTrees() > 25){
            if(Game.getVillage().getStrengthAvg() > 6){
                if(Game.getGameBoard().getTrees() >50){
                    amountOfWoodToReturn+=50;
                } else{
                    amountOfWoodToReturn += Game.getGameBoard().getTrees();
                }
                Game.getGameBoard().reduceTreesOnBoard(50);
            }


        } else{
            amountOfWoodToReturn += Game.getGameBoard().getTrees();
        }

        Game.getVillage().incWood(amountOfWoodToReturn);

        this.isDone = true;
    }
}

