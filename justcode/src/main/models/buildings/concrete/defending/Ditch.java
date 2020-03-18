package main.models.buildings.concrete.defending;

import main.models.buildings.abstracts.*;
import main.models.resources.*;
import main.models.resources.natural.*;

public class Ditch extends AbstractDefenses {

    public Ditch() {
        super("Ditch", 0, 1, new Wood());
    }
}
