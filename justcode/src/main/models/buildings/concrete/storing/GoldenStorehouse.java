package main.models.buildings.concrete.storing;

import main.interfaces.*;
import main.models.buildings.abstracts.*;
import main.models.resources.*;
import main.models.resources.natural.*;

public class GoldenStorehouse extends AbstractStorehouse implements Golden {

    public GoldenStorehouse() {
        super("Golden Storehouse", 600, 3500, new Gold());
    }

    @Override
    public Integer getGoldAmt() {
        return 500;
    }
}
