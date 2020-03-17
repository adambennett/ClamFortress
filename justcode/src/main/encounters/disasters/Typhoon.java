package main.encounters.disasters;

import main.models.*;

public class Typhoon extends AbstractDisaster {
    @Override
    public void runEncounter() {
        Game.getVillage().addDisaster(this);
    }

    @Override
    public String toString() {
        return "A Typhoon is causing chaos!";
    }
}