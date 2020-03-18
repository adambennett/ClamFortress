package main.models.buildings.concrete.housing;

import main.models.buildings.abstracts.*;
import main.models.resources.natural.*;

public class SmallWoodHome extends AbstractHouse {

    public SmallWoodHome() {
        super("Small Wood Home", 8, 100, new Wood());
    }

    @Override
    public SmallWoodHome clone() {
        return new SmallWoodHome();
    }
}
