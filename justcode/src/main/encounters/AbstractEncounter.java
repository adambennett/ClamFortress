package main.encounters;

public abstract class AbstractEncounter {

    public abstract void runEncounter();

    public void standbyPhase() {}

    public void priorityPhase() {}

    public void endPhase() {}

    @Override
    public abstract String toString();
}
