package main.encounters.plagues;

import main.models.*;

import java.util.concurrent.*;

public class SpanishFlu extends AbstractPlague {

    public SpanishFlu(int turns) {
        super("Spanish Flu", "A very serious strain of influenza. Causes a random amount of damage at the start of each end phase.", turns);
    }

    @Override
    public void endPhase() {
        int dmgLeft = ThreadLocalRandom.current().nextInt(10, 350);
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
        return "Spanish Flu has stricken your village!";
    }

    @Override
    public SpanishFlu clone() {
        return new SpanishFlu(this.turnsActive);
    }
}
