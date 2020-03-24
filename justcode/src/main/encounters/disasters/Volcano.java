package main.encounters.disasters;

import main.models.*;
import main.utilities.stringUtils.*;

public class Volcano extends AbstractDisaster {



    public Volcano() {
        super("Mt. " + GameStrings.getRandomName(true), "An active volcano that erupts all over your village!", 1);
    }

    @Override
    public void runEncounter() { Game.getVillage().addDisaster(this); }

    @Override
    public String toString() {
        return "Mt. " + this.getName() + " has erupted!";
    }

    @Override
    public Volcano clone() {
        return new Volcano();
    }
}
