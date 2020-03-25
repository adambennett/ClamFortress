package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.tools.gathering;

public class Net extends AbstractGatheringTool {
    public Net() {
        super("Net", "Used to improve Fishing.");
    }

    @Override
    public Net clone() {
        return new Net();
    }
}


