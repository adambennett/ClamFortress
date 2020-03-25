package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.tools.engineering;

public class Blueprint extends AbstractEngTool {
    public Blueprint() {
        super("Blueprint", "Used to learn about new structures to Build.");
    }

    @Override
    public Blueprint clone() {
        return new Blueprint();
    }
}
