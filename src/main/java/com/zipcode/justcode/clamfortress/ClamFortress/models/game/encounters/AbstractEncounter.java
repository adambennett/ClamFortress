package com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.other.*;

public abstract class AbstractEncounter extends GameObject {

    protected Integer turnsActive;

    public AbstractEncounter(String name, String desc, int turnsActive) {
        super(name, desc);
        this.turnsActive = turnsActive;
    }

    public abstract void runEncounter();

    public void setTurnsActive(Integer turnsActive) {
        this.turnsActive = turnsActive;
    }

    public Integer getTurnsActive() {
        return turnsActive;
    }

    @Override
    public abstract String toString();

   /* @Override
    public abstract AbstractEncounter clone();*/

}
