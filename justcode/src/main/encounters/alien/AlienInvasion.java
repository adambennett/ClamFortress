package main.encounters.alien;

import main.models.*;
import main.models.beings.*;
import main.models.nodes.*;
import main.models.resources.*;

import java.util.*;

public class AlienInvasion extends AlienEncounter {

    private Integer damage;

    public AlienInvasion(int turns, int dmg) {
        super("Alien Invasion", "Aliens invade and deal damage to your villagers.", turns);
        this.damage = dmg;
    }

    @Override
    public String toString() {
        return "Alien Invasion!!";
    }

    @Override
    public Map<AbstractResource, Integer> dropResources() {
        return new HashMap<>();
    }

    @Override
    public ArrayList<Alien> invade() {
        return null;
    }

    @Override
    public Integer dealDamage(AbstractNode underAtk) {
        return this.damage;
    }

    @Override
    public void runEncounter() {

    }

    @Override
    public AlienInvasion clone() {
        return null;
    }
}
