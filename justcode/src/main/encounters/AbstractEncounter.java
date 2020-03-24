package main.encounters;

import main.models.*;

public abstract class AbstractEncounter extends GameObject {

    protected Integer turnsActive;

    public AbstractEncounter(String name, String desc, int turnsActive) {
        super(name, desc);
        this.turnsActive = turnsActive;
    }

    public abstract void runEncounter();

    @Override
    public abstract String toString();

}
