package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.tools.engineering;

public class Hammer extends AbstractEngTool {
    public Hammer() {
        super("Hammer", "Used to improve Engineering.");
    }

    @Override
    public Hammer clone() {
        return new Hammer();
    }
}
