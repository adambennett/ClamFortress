package clamFortress.actions;

import clamFortress.game.*;
import clamFortress.models.buildings.abstracts.*;

import java.util.concurrent.*;

public class Praying extends AbstractGameAction {

    public Praying(Game game) {
        this.setValues(game);
        this.actionType = ActionType.PRAYING;
    }

    @Override
    public void update() {
        int faithBuildingMod = 0;
        for (AbstractBuilding b : currentGame.getVillage().getBuildings()) {
            if (b instanceof AbstractFaithBuilding) {
                faithBuildingMod += ((AbstractFaithBuilding) b).getPrayBonus();
            }
        }
        if (faithBuildingMod < 10) {
            faithBuildingMod = 10;
        }
        currentGame.getVillage().incFaith(ThreadLocalRandom.current().nextInt(faithBuildingMod));
        this.isDone = true;
    }


}
