package main.encounters.disasters;

import main.game.*;

public class Earthquake extends AbstractDisaster {
    @Override
    public void runEncounter() {
        Game.getVillage().addDisaster(this);
    }
}
