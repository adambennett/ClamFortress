package main.models.items.tools.gathering;

import main.models.items.tools.*;

public class Net extends AbstractGatheringTool {
    public Net() {
        super("Net", "Used to improve Fishing.");
    }

    @Override
    public Net clone() {
        return new Net();
    }
}


