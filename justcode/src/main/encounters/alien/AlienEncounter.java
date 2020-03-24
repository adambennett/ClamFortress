package main.encounters.alien;

import main.encounters.*;
import main.models.beings.*;
import main.models.nodes.*;
import main.models.resources.*;

import java.util.*;

public abstract class AlienEncounter extends AbstractEncounter {

    public AlienEncounter(String name, String desc, int turns) {
        super(name, desc, turns);
    }

    public abstract Map<AbstractResource, Integer> dropResources();

    public abstract ArrayList<Alien> invade();

    public abstract Integer dealDamage(AbstractNode underAtk);

    @Override
    public abstract void runEncounter();
}
