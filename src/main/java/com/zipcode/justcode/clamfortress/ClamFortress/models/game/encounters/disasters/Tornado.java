package com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.disasters;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

public class Tornado extends AbstractDisaster {


    public Tornado(int turns) {
        super("Tornado", "A crazy strong tornado rips through your village.", turns);
    }

    @Override
    public void runEncounter() {
        Database.getCurrentGame().getVillage().addDisaster(this);
    }

    @Override
    public String toString() {
        return "A Tornado is causing chaos!";
    }

    @Override
    public Tornado clone() {
        return new Tornado(this.turnsActive);
    }
}