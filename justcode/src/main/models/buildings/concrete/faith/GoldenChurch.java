package main.models.buildings.concrete.faith;

import main.interfaces.*;
import main.models.*;
import main.models.buildings.abstracts.*;
import main.models.resources.*;
import main.models.resources.natural.*;

public class GoldenChurch extends AbstractFaithBuilding implements Golden {

    public GoldenChurch() {
        super("Golden Church", 650, 125, 200, new Gold());
    }

    @Override
    public Integer getGoldAmt() {
        return 450;
    }

    @Override
    public GoldenChurch clone() {
        return new GoldenChurch();
    }
}
