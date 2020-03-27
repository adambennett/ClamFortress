package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.artifacts;

import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

public class ClericCloak extends AbstractArtifact implements Unique {

    public ClericCloak() {
        super("Cleric Cloak", "During each End Phase, gain Coins equal to your current Faith.");
    }

    @Override
    public void endPhase() {
        Database.getCurrentGame().getVillage().incCoins(Database.getCurrentGame().getVillage().getFaith());
    }

    @Override
    public ClericCloak clone() {
        return new ClericCloak();
    }
}
