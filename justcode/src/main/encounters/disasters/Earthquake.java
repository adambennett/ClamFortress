package main.encounters.disasters;

import main.models.*;

public class Earthquake extends AbstractDisaster {
    @Override
    public void runEncounter() {
        Game.getVillage().addDisaster(this);
    }

    @Override
    public String toString() {
        return "There was an Earthquake!";
    }
}
