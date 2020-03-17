package main.encounters.plagues;

import main.models.*;

public class SARS extends AbstractPlague {
    @Override
    public void runEncounter() {
        Game.getVillage().addPlague(this);
    }

    @Override
    public String toString() {
        return "SARS has stricken your village!";
    }
}
