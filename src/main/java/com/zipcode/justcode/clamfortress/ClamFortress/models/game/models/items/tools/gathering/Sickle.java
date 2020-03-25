package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.tools.gathering;

public class Sickle extends AbstractGatheringTool {
    public Sickle() {
        super("Sickle", "Improves Seed collection rates.");
    }

    @Override
    public Sickle clone() {
        return new Sickle();
    }
}