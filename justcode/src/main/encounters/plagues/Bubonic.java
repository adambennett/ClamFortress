package main.encounters.plagues;

import main.game.*;

public class Bubonic extends AbstractPlague {
    @Override
    public void runEncounter() {
        Game.getVillage().addPlague(this);
    }
}
