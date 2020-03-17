package main.encounters.miracles;

import main.models.*;

public class Wisdom extends AbstractMiracle {
    @Override
    public void runEncounter() {
        Game.getVillage().addMiracle(this);
    }

    @Override
    public String toString() {
        return "Miracle: Wisdom";
    }
}
