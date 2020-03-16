package clamFortress.encounters.plagues;

import clamFortress.game.*;
import clamFortress.models.*;

public class H1N1 extends AbstractPlague {
    @Override
    public void runEncounter() {
        Game.getVillage().addPlague(this);
    }
}
