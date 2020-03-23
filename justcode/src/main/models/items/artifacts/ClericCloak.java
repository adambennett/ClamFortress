package main.models.items.artifacts;

import main.interfaces.*;
import main.models.*;

public class ClericCloak extends AbstractArtifact implements Unique {

    public ClericCloak() {
        super("Cleric Cloak", "During each End Phase, gain Coins equal to your current Faith.");
    }

    @Override
    public void endPhase() {
        Game.getVillage().incCoins(Game.getVillage().getFaith());
    }

    @Override
    public ClericCloak clone() {
        return new ClericCloak();
    }
}
