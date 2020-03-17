package main.encounters.disasters;

import main.models.*;

public class Flood extends AbstractDisaster {
    @Override
    public void runEncounter() {
        Game.getVillage().addDisaster(this);
    }

    @Override
    public String toString() {
        return "A Flood has destroyed some of your buildings!";
    }
}
