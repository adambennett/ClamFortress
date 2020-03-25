package com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.plagues;



public class Contagion extends AbstractPlague {

    public Contagion(int turns) {
        super("Contagion", "A general contagion. Causes random negative effects for several turns.", turns);
    }

    @Override
    public String toString() {
        return "An Unknown Contagion has stricken your village!";
    }

    @Override
    public Contagion clone() {
        return new Contagion(this.turnsActive);
    }
}
