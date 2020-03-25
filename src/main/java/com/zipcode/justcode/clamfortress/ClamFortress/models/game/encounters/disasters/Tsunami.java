package com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.disasters;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;

public class Tsunami extends AbstractDisaster {
    public Tsunami() {
        super("Tsunami", "A gigantic tsunami has wrecked your shore lines!", 1);
    }

    @Override
    public void runEncounter() {
        Game.getVillage().addDisaster(this);
    }

    @Override
    public String toString() {
        return "A Tsunami has devasted your beaches!";
    }

    @Override
    public Tsunami clone() {
        return new Tsunami();
    }
}