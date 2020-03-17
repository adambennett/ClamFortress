package main.encounters.disasters;

import main.game.*;

public class Flood extends AbstractDisaster {
    @Override
    public void runEncounter() {
        Game.getVillage().addDisaster(this);
    }
}
