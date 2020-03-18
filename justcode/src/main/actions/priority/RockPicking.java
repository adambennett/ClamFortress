package main.actions.priority;

import main.actions.*;
import main.enums.*;
import main.models.Game;
import main.models.items.tools.gathering.Pickaxe;
import main.models.managers.*;
import main.models.resources.natural.*;

import java.util.concurrent.*;

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

        } else {
            rockToReturn = ThreadLocalRandom.current().nextInt(0, 5);
        }
        for (int i = 0; i < rockToReturn; i++) {
            Game.getVillage().addResource(new Rock());
        }
        if (rockToReturn > 0) {
            OutputManager.addToBot("Picked " + rockToReturn + " rocks!");
        }
        this.isDone = true;
    }

    @Override
    public RockPicking clone() {
        return new RockPicking();
    }
}
