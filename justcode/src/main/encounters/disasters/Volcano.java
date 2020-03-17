package main.encounters.disasters;

import main.models.*;

public class Volcano extends AbstractDisaster {
    @Override
    public void runEncounter() { Game.getVillage().addDisaster(this); }
}
