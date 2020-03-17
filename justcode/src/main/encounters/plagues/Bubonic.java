package main.encounters.plagues;

import main.models.*;

public class Bubonic extends AbstractPlague {
    @Override
    public void runEncounter() {
        Game.getVillage().addPlague(this);
    }

    @Override
    public String toString() {
        return "Bubonic Plague has stricken your village!";
    }
}
