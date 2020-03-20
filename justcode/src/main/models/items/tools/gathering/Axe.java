package main.models.items.tools.gathering;

import main.models.items.tools.AbstractTool;
import main.models.items.tools.engineering.*;

public class Axe extends AbstractGatheringTool {
    public Axe() {
        super("Axe", "Used to improve Woodcutting.");
    }

    @Override
    public Axe clone() {
        return new Axe();
    }
}