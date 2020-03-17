package main.encounters.plagues;

import main.models.*;

public class Pandemic extends AbstractPlague {
    @Override
    public void runEncounter() {
        Game.getVillage().addPlague(this);
    }

    @Override
    public String toString() {
        return "Mass Pandemic has stricken your village!";
    }
}
