package main.encounters.plagues;

import main.models.*;

public class COVID19 extends AbstractPlague {
    @Override
    public void runEncounter() {
        Game.getVillage().addPlague(this);
    }

    @Override
    public String toString() {
        return "COVID-19 has stricken your village!";
    }
}
