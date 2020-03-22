package main.models.items.tools.gathering;

import main.models.*;
import main.models.resources.natural.*;
import main.models.tech.*;

import java.util.concurrent.*;

public class GooGenerator extends AbstractGatheringTool {
    public GooGenerator() {
        super("Goo Generator", "Generates Spacegoo passively at the start of each standby phase.");
    }

    @Override
    public Boolean canObtain() {
        return TechTree.getCurrentEra().equals(TechTree.getTail());
    }

    @Override
    public void standbyPhase() {
        Game.getVillage().addResource(new Spacegoo(), ThreadLocalRandom.current().nextInt(100, 200));
    }

    @Override
    public GooGenerator clone() {
        return new GooGenerator();
    }
}
