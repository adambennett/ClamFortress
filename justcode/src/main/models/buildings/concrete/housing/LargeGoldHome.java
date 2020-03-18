package main.models.buildings.concrete.housing;

import main.interfaces.*;
import main.models.buildings.abstracts.*;
import main.models.resources.natural.*;

public class LargeGoldHome extends AbstractHouse implements Golden {

    public LargeGoldHome() {
        super("Large Golden Home", 60, 1500, new Gold());
    }

    @Override
    public Integer getGoldAmt() {
        return 1000;
    }
}
