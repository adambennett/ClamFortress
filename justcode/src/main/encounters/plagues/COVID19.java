package main.encounters.plagues;

import main.models.*;

public class COVID19 extends AbstractPlague {
    @Override
    public void runEncounter() {
        Game.getVillage().addPlague(this);
    }
}
