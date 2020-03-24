package main.encounters.miracles;

import main.actions.priority.*;
import main.models.*;

import java.util.concurrent.*;

public class DivineHealing extends AbstractMiracle {

    public DivineHealing(int turns) {
        super("Divine Healing", "A divine blessing! Grants free healing actions at the start of each standby phase.", turns);
    }

    @Override
    public void standbyPhase() {
        int high = ThreadLocalRandom.current().nextInt(1, 5);
        if (Game.getVillage().getFaith() > Game.getVillage().getFaithLimit() - 25) {
            high += ThreadLocalRandom.current().nextInt(1, 3);
        }
        Game.actionManager.addToBottom(new Healing(high));
        this.turnsActive--;
        if (this.turnsActive < 1) {
            Game.getVillage().getActiveMiracles().remove(this);
        }
    }

    @Override
    public String toString() {
        return "Divine Healing";
    }

    @Override
    public DivineHealing clone() {
        return new DivineHealing(this.turnsActive);
    }
}
