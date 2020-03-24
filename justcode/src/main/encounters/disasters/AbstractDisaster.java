package main.encounters.disasters;

import main.encounters.*;

public abstract class AbstractDisaster extends AbstractEncounter {
    public AbstractDisaster(String name, String desc, int turns) {
        super(name, desc, turns);
    }

    @Override
    public abstract void runEncounter();
}
