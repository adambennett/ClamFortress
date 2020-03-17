package main.actions.priority;

import main.actions.*;
import main.models.*;

public class Woodcutting extends AbstractGameAction {

    @Override
    public void update() {
        Integer amountOfWoodToReturn = 15;

            if(Game.getVillage().getStrengthAvg() > 6){
                if(Game.getGameBoard().getTrees() >50){
                    amountOfWoodToReturn+=50;
                } else{
                    amountOfWoodToReturn += Game.getGameBoard().getTrees();
                }
                Game.getGameBoard().reduceTreesOnBoard(50);
            } else {
            amountOfWoodToReturn += Game.getGameBoard().getTrees();
        }

        Game.getVillage().incWood(amountOfWoodToReturn);

        this.isDone = true;
    }
}

