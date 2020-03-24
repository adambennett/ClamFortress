package main.encounters.disasters;

import main.models.*;
import main.utilities.stringUtils.*;

public class Hurricane extends AbstractDisaster {

    public Hurricane(int turns) {
        super("Hurricane " + GameStrings.getRandomName(false), "A huge hurricane that impacts your village with devastation.", turns);
    }

    @Override
    public void runEncounter() {
        Game.getVillage().addDisaster(this);
    }

    @Override
    public String toString() {
        return "Hurricane " + this.getName() + " has created havoc in your village!";
    }

    @Override
    public Hurricane clone() {
        return new Hurricane(this.turnsActive);
    }
}
