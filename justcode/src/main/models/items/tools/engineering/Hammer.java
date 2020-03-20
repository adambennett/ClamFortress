package main.models.items.tools.engineering;

import main.models.items.tools.*;

public class Hammer extends AbstractEngTool {
    public Hammer() {
        super("Hammer", "Used to improve Engineering.");
    }

    @Override
    public Hammer clone() {
        return new Hammer();
    }
}
