package main.models.buildings.concrete.refining;

import main.models.buildings.abstracts.*;
import main.models.buildings.concrete.housing.*;
import main.models.resources.*;
import main.models.resources.natural.*;
import main.models.resources.refined.*;

public class Kiln extends AbstractRefining {

    public Kiln() {
        super("Kiln", 50, new Stone(), new Clay());
    }

    @Override
    public Kiln clone() {
        return new Kiln();
    }
}
