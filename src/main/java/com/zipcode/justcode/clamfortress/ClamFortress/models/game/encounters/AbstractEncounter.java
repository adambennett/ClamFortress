package com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;

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
