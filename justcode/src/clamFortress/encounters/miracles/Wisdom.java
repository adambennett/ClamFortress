package clamFortress.encounters.miracles;

import clamFortress.game.*;
import clamFortress.models.*;

public class Wisdom extends AbstractMiracle {
    @Override
    public void runEncounter() {
        Game.getVillage().addMiracle(this);
    }
}
