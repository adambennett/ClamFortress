package main.encounters.disasters;

import main.models.*;

public class Tsunami extends AbstractDisaster {
    @Override
    public void runEncounter() {
        Game.getVillage().addDisaster(this);
    }

    @Override
    public String toString() {
        return "A Tsunami has devasted your beaches!";
    }
}