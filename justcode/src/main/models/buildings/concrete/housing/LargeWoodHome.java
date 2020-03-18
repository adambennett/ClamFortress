package main.models.buildings.concrete.housing;

import main.models.buildings.abstracts.*;
import main.models.resources.natural.*;

public class LargeWoodHome extends AbstractHouse {

    public LargeWoodHome() {
        super("Large Wood Home", 20, 800, new Wood());
    }
}
