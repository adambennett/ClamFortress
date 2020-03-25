package com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.disasters;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;

public class Flood extends AbstractDisaster {
    public Flood(int turns) {
        super("Flood", "A devastating flood that destroys buildings.", turns);
    }

    @Override
    public void runEncounter() {
        Game.getVillage().addDisaster(this);
    }

    @Override
    public String toString() {
        return "A Flood has destroyed some of your buildings!";
    }

    @Override
    public Flood clone() {
        return new Flood(this.turnsActive);
    }
}
