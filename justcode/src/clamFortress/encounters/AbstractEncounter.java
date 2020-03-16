package clamFortress.encounters;

import clamFortress.models.*;

public abstract class AbstractEncounter {

    public abstract void runEncounter();

    public void standbyPhase() {}

    public void priorityPhase() {}

    public void endPhase() {}
}
