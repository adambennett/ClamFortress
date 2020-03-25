package com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.disasters;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.*;

public abstract class AbstractDisaster extends AbstractEncounter {
    public AbstractDisaster(String name, String desc, int turns) {
        super(name, desc, turns);
    }

    @Override
    public abstract void runEncounter();
}
