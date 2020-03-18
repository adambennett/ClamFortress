package main.actions.priority;

import main.actions.*;
import main.models.*;
import main.models.resources.natural.*;

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
        for (int i = 0; i < amountOfWoodToReturn; i++) {
            Game.getVillage().addResource(new Wood());
        }
        this.isDone = true;
    }

    @Override
    public Woodcutting clone() {
        return new Woodcutting();
    }
}

