package main.encounters.disasters;

import main.models.*;

public class Typhoon extends AbstractDisaster {
    public Typhoon(int turns) {
        super("Typhoon", "A mega typhoon that forms off the coast.", turns);
    }

    @Override
    public void runEncounter() {
        Game.getVillage().addDisaster(this);
    }

    @Override
    public String toString() {
        return "A Typhoon is causing chaos!";
    }

    @Override
    public Typhoon clone() {
        return new Typhoon(this.turnsActive);
    }
}