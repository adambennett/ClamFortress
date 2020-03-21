package main.encounters.disasters;

import main.models.*;
import main.utilities.stringUtils.*;

public class Hurricane extends AbstractDisaster {

    private final String name;

    public Hurricane() {
        this.name = GameStrings.getRandomName(false);
    }

    @Override
    public void runEncounter() {
        Game.getVillage().addDisaster(this);
    }

    @Override
    public String toString() {
        return "Hurricane " + name + " has created havoc in your village!";
    }
}
