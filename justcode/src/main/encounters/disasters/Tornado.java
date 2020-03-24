package main.encounters.disasters;

import main.models.*;

public class Tornado extends AbstractDisaster {


    public Tornado(int turns) {
        super("Tornado", "A crazy strong tornado rips through your village.", turns);
    }

    @Override
    public void runEncounter() {
        Game.getVillage().addDisaster(this);
    }

    @Override
    public String toString() {
        return "A Tornado is causing chaos!";
    }

    @Override
    public Tornado clone() {
        return new Tornado(this.turnsActive);
    }
}