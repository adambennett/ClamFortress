package main.encounters.disasters;

import main.models.*;

public class Earthquake extends AbstractDisaster {


    public Earthquake() {
        super("Earthquake", "A massive earthquake that shakes up your village, dealing damage and causing destruction of buildings.", 1);
    }

    @Override
    public void runEncounter() {
        Game.getVillage().addDisaster(this);
    }

    @Override
    public String toString() {
        return "There was an Earthquake!";
    }

    @Override
    public Earthquake clone() {
        return new Earthquake();
    }
}
