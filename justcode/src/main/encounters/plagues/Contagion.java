package main.encounters.plagues;

import main.models.*;

public class Contagion extends AbstractPlague {
    @Override
    public void runEncounter() {
        Game.getVillage().addPlague(this);
    }
}
