package main.models.buildings.concrete.defending;

import main.models.*;
import main.models.buildings.abstracts.*;
import main.models.resources.*;
import main.models.resources.natural.*;

public class WoodSpikeWall extends AbstractDefenses {

    public WoodSpikeWall(String name, int resourceCost, AbstractResource resourceType) {
        super("Wood Spike Wall", 75 + Game.getVillage().getSurvivors().size(), 3, new Wood());
    }
}
