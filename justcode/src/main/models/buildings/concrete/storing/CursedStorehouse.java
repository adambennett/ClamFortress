package main.models.buildings.concrete.storing;

import main.interfaces.*;
import main.models.buildings.abstracts.*;
import main.models.resources.*;
import main.models.resources.natural.*;

public class CursedStorehouse extends AbstractStorehouse implements Cursed {

    public CursedStorehouse() {
        super("Cursed Storehouse", 50, 2000, new Clay());
    }

    @Override
    public void runCurse() {

    }
}
