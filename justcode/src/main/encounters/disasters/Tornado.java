package main.encounters.disasters;

import main.models.*;

public class Tornado extends AbstractDisaster {
    @Override
    public void runEncounter() {
        Game.getVillage().addDisaster(this);
    }

    @Override
    public String toString() {
        return "A Tornado is causing chaos!";
    }
}