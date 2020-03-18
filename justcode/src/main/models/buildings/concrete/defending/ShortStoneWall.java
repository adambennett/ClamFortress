package main.models.buildings.concrete.defending;

import main.models.*;
import main.models.buildings.abstracts.*;
import main.models.resources.*;
import main.models.resources.refined.*;

public class ShortStoneWall extends AbstractDefenses {

    public ShortStoneWall() {
        super("Short Stone Wall", 150 + Game.getVillage().getSurvivors().size(), 2, new Stone());
    }
}
