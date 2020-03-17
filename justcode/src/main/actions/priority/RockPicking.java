package main.actions.priority;

import main.actions.*;
import main.models.Game;
import main.models.items.tools.gathering.Pickaxe;

public class RockPicking extends AbstractGameAction {

    @Override
    public void update() {
        Pickaxe pickaxe = new Pickaxe();
        int rockToReturn = 15;
        Integer rocksOnBoard = Game.getGameBoard().getRocks();
        if(rocksOnBoard > 0){
            if(Game.getVillage().getInventory().containsItem(pickaxe.getName())){
                rockToReturn *= 2;
            }
            Game.getVillage().incRock(rockToReturn);
        }
        this.isDone = true;
    }

    @Override
    public RockPicking clone() {
        return new RockPicking();
    }
}
