package main.actions.priority;

import main.actions.*;
import main.models.*;
import main.models.items.*;
import main.models.items.artifacts.*;
import main.models.buildings.abstracts.*;
import main.models.managers.*;

import java.util.concurrent.*;

public class Praying extends AbstractGameAction {

    @Override
    public void update() {
        int faithBuildingMod = 0;
        for (AbstractBuilding b : Game.getVillage().getBuildings()) {
            if (b instanceof AbstractFaithBuilding) {
                faithBuildingMod += ((AbstractFaithBuilding) b).getPrayBonus();
            }
        }
        if (faithBuildingMod < 1) {
            faithBuildingMod = 1;
        }

        for (AbstractItem a : Game.getVillage().getInventory().getItems()) {
            faithBuildingMod += a.modifyFaithInc();
        }

        int amt = ThreadLocalRandom.current().nextInt(faithBuildingMod+1);
        if (amt > 0) {
            Game.getVillage().incFaith(amt);
            OutputManager.addToBot("Praying has earned you " + faithBuildingMod + " Faith");
        }
        this.isDone = true;
    }

    @Override
    public Praying clone() {
        return new Praying();
    }


}
