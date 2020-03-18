package main.models.buildings.concrete.defending;

import main.models.*;
import main.models.buildings.abstracts.*;
import main.models.resources.*;
import main.models.resources.natural.*;

public class WoodSpikeWall extends AbstractDefenses {

    public WoodSpikeWall() {
        super("Wood Spike Wall", 75 + Game.getVillage().getPopulation(), 3, new Wood());
    }

    @Override
    public WoodSpikeWall clone() {
        return new WoodSpikeWall();
    }
}
