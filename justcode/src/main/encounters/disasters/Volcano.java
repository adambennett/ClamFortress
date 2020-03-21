package main.encounters.disasters;

import main.models.*;
import main.utilities.stringUtils.*;

public class Volcano extends AbstractDisaster {

    private final String name;

    public Volcano() {
        this.name = GameStrings.getRandomName(true);
    }

    @Override
    public void runEncounter() { Game.getVillage().addDisaster(this); }

    @Override
    public String toString() {
        return "Mt. " + name + " has erupted!";
    }
}
