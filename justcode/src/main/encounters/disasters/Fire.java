package main.encounters.disasters;

import main.models.*;

public class Fire extends AbstractDisaster {
    @Override
    public void runEncounter() {
        Game.getVillage().addDisaster(this);
    }

    @Override
    public String toString() {
        return "A Fire has ravaged your village!";
    }
}
