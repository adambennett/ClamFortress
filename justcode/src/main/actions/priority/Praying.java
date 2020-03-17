package main.actions.priority;

import main.actions.*;
import main.models.*;
import main.models.items.artifacts.*;
import main.models.buildings.abstracts.*;

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
        if (faithBuildingMod < 10) {
            faithBuildingMod = 10;
        }

        for (AbstractArtifact a : Game.getVillage().getInventory().getArtifacts()) {
            faithBuildingMod += a.modifyFaithInc();
        }

        Game.getVillage().incFaith(ThreadLocalRandom.current().nextInt(faithBuildingMod));
        this.isDone = true;
    }

    @Override
    public Praying clone() {
        return new Praying();
    }


}
