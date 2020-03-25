package com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.plagues;


public class Pandemic extends AbstractPlague {

    public Pandemic(int turns) {
        super("Pandemic", "A general pandemic. Causes your villagers to consume extra food each turn.", turns);
    }

    @Override
    public String toString() {
        return "Mass Pandemic has stricken your village for " + this.turnsActive + " turns!";
    }

    @Override
    public Pandemic clone() {
        return new Pandemic(this.turnsActive);
    }
}
