package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.artifacts;

import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;

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
