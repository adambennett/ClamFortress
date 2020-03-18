package main.models.buildings.concrete.housing;

import main.interfaces.*;
import main.models.buildings.abstracts.*;
import main.models.resources.natural.*;

public class SmallGoldHome extends AbstractHouse implements Golden {

    public SmallGoldHome() {
        super("Small Gold Home", 50, 550, new Gold());
    }

    @Override
    public Integer getGoldAmt() {
        return 500;
    }
}
