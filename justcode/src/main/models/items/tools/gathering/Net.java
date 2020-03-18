package main.models.items.tools.gathering;

import main.models.items.tools.*;

public class Net extends AbstractGatheringTool {
    public Net() {
        super("Net", "");
    }

    @Override
    public Net clone() {
        return new Net();
    }
}


