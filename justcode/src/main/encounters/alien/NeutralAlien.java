package main.encounters.alien;

import main.models.*;
import main.models.beings.*;
import main.models.nodes.*;
import main.models.resources.*;

import java.util.*;

public class NeutralAlien extends AlienEncounter {
    public NeutralAlien(int turns) {
        super("Neutral Alien", "Neutral Alien encounter", turns);
    }

    @Override
    public Map<AbstractResource, Integer> dropResources() {
        return null;
    }

    @Override
    public ArrayList<Alien> invade() {
        return null;
    }

    @Override
    public Integer dealDamage(AbstractNode underAtk) {
        return null;
    }

    @Override
    public void runEncounter() {

    }

    @Override
    public String toString() {
        return "Aliens walk among us...";
    }

    @Override
    public NeutralAlien clone() {
        return new NeutralAlien(this.turnsActive);
    }
}
