package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.concrete.refining;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.refined.*;

public class Kiln extends AbstractRefining {

    public Kiln() {
        super("Kiln", 50, new Stone(), new Clay());
    }

    @Override
    public Kiln clone() {
        return new Kiln();
    }
}
