package main.encounters.miracles;

import main.encounters.*;
import main.models.*;

public abstract class AbstractMiracle extends AbstractEncounter {

    public AbstractMiracle(String name, String desc, int turns) {
        super(name, desc, turns);
    }

    @Override
    public void runEncounter() {
        Game.getVillage().addMiracle(this);
    }

}
