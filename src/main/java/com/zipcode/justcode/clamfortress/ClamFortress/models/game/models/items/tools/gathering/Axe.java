package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.tools.gathering;

public class Axe extends AbstractGatheringTool {
    public Axe() {
        super("Axe", "Used to improve Woodcutting.");
    }

    @Override
    public Axe clone() {
        return new Axe();
    }
}