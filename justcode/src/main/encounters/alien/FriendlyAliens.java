package main.encounters.alien;

import main.models.*;
import main.models.beings.*;
import main.models.nodes.*;
import main.models.resources.*;

import java.util.*;

public class FriendlyAliens extends AlienEncounter {
    public FriendlyAliens(int turns) {
        super("Friendly Aliens", "Temp desc", turns);
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
        return "Friendly Aliens have visited your game...";
    }

    @Override
    public FriendlyAliens clone() {
        return new FriendlyAliens(this.turnsActive);
    }
}
