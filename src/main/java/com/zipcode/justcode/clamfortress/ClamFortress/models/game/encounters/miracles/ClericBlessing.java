package com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.miracles;

public class ClericBlessing extends AbstractMiracle {

    public ClericBlessing(int turns) {
        super("Cleric Blessing", "", turns);
    }

    @Override
    public String toString() {
        return "Miracle: Blessing";
    }

    @Override
    public ClericBlessing clone() {
        return new ClericBlessing(this.turnsActive);
    }
}
