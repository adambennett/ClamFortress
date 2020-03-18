package main.models.buildings.concrete.defending;

import main.interfaces.*;
import main.models.*;
import main.models.buildings.abstracts.*;
import main.models.resources.natural.*;

public class GoldenWatchtower extends AbstractDefenses implements Golden {

    public GoldenWatchtower() {
        super("Golden Watchtower", 500, 100, new Gold());
    }

    @Override
    public Integer getGoldAmt() {
        return 400;
    }

    @Override
    public GoldenWatchtower clone() {
        return new GoldenWatchtower();
    }
}
