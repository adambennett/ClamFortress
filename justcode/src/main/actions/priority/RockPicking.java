package main.actions.priority;

import main.actions.*;
import main.models.Game;
import main.models.items.tools.gathering.Pickaxe;

public class RockPicking extends AbstractGameAction {

    @Override
    public void update() {
        Pickaxe pickaxe = new Pickaxe();
        Integer rockToReturn = 15;
        Integer rocksOnBoard = Game.getGameBoard().getRocks();
        if(rocksOnBoard > 0){
            if(Game.getVillage().getInventory().containsTool(pickaxe)){
                rockToReturn *= 2;
            }
            Game.getVillage().incRock(rockToReturn);
        }
        this.isDone = true;
    }
}
