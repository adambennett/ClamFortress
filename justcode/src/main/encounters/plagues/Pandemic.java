package main.encounters.plagues;

import main.models.*;

public class Pandemic extends AbstractPlague {
    @Override
    public void runEncounter() {
        Game.getVillage().addPlague(this);
    }
}
