package clamFortress.encounters.miracles;

import clamFortress.game.*;
import clamFortress.models.*;

public class Blessing extends AbstractMiracle {
    @Override
    public void runEncounter() {
        Game.getVillage().addMiracle(this);
    }
}
