package main.encounters.disasters;

import main.models.*;

public class Hurricane extends AbstractDisaster {
    @Override
    public void runEncounter() {
        Game.getVillage().addDisaster(this);
    }
}
