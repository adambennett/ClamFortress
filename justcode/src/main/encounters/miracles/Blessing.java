package main.encounters.miracles;

import main.models.*;

public class Blessing extends AbstractMiracle {
    @Override
    public void runEncounter() {
        Game.getVillage().addMiracle(this);
    }
}
