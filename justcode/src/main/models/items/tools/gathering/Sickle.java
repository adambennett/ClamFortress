package main.models.items.tools.gathering;

import main.models.items.tools.*;

public class Sickle extends AbstractGatheringTool {
    public Sickle() {
        super("Sickle", "");
    }

    @Override
    public Sickle clone() {
        return new Sickle();
    }
}