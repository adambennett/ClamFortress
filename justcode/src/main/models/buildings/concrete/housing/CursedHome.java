package main.models.buildings.concrete.housing;

import main.interfaces.*;
import main.models.*;
import main.models.buildings.abstracts.*;
import main.models.resources.natural.*;

public class CursedHome extends AbstractHouse implements Cursed {

    public CursedHome() {
        super("Cursed Home", 50, 200, new Clay());
    }

    @Override
    public CursedHome clone() {
        return new CursedHome();
    }
}
