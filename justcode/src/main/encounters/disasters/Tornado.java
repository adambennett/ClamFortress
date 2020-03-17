package main.encounters.disasters;

import main.models.*;

public class Tornado extends AbstractDisaster {
    @Override
    public void runEncounter() {
        Game.getVillage().addDisaster(this);
    }
}