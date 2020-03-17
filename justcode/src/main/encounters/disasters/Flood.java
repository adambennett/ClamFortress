package main.encounters.disasters;

import main.models.*;

public class Flood extends AbstractDisaster {
    @Override
    public void runEncounter() {
        Game.getVillage().addDisaster(this);
    }
}
