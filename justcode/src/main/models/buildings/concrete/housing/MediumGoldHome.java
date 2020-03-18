package main.models.buildings.concrete.housing;

import main.interfaces.*;
import main.models.buildings.abstracts.*;
import main.models.resources.natural.*;

public class MediumGoldHome extends AbstractHouse implements Golden {

    public MediumGoldHome() {
        super("Medium Golden Home", 55, 400, new Gold());
    }

    @Override
    public Integer getGoldAmt() {
        return 300;
    }
}
