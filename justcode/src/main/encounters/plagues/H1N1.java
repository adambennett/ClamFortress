package main.encounters.plagues;

import main.models.*;

public class H1N1 extends AbstractPlague {
    @Override
    public void runEncounter() {
        Game.getVillage().addPlague(this);
    }
}
