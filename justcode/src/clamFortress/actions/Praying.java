package clamFortress.actions;

import clamFortress.game.*;
import clamFortress.models.buildings.abstracts.*;

import java.util.concurrent.*;

public class Praying extends AbstractGameAction {

    public Praying() {
        this.actionType = ActionType.PRAYING;
    }

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
        Game.getVillage().incFaith(ThreadLocalRandom.current().nextInt(faithBuildingMod));
        this.isDone = true;
    }


}
