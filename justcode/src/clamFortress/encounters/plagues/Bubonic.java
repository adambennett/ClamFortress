package clamFortress.encounters.plagues;

import clamFortress.game.*;
import clamFortress.models.*;

public class Bubonic extends AbstractPlague {
    @Override
    public void runEncounter() {
        Game.getVillage().addPlague(this);
    }
}
