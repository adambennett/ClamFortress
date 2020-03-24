package main.encounters.plagues;

import main.models.*;

import java.util.concurrent.*;

public class Bubonic extends AbstractPlague {

    public Bubonic(int turns) {
        super("Bubonic", "Bubonic Plague. Deals 100 damage spread among random villagers at the start of each end phase.", turns);
    }

    @Override
    public void endPhase() {
        int dmgLeft = 100;
        while (dmgLeft > 0) {
            int dmged = ThreadLocalRandom.current().nextInt(0, dmgLeft);
            Game.getVillage().takeDamage(dmged);
            dmgLeft -= dmged;
        }

        this.turnsActive--;
        if (this.turnsActive < 1) {
            Game.getVillage().getOngoingPlagues().remove(this);
        }
    }

    @Override
    public String toString() {
        return "Bubonic Plague has stricken your village for " + this.turnsActive + " turns!";
    }

    @Override
    public Bubonic clone() {
        return new Bubonic(this.turnsActive);
    }
}
