package clamFortress.encounters.disasters;

import clamFortress.game.*;
import clamFortress.models.*;

public class Volcano extends AbstractDisaster {
    @Override
    public void runEncounter() { Game.getVillage().addDisaster(this); }
}
