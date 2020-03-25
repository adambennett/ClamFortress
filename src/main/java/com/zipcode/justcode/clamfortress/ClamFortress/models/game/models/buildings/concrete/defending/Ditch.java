package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.concrete.defending;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural.*;

public class Ditch extends AbstractDefenses {

    public Ditch() {
        super("Ditch", 0, 1, new Wood());
    }

    @Override
    public Ditch clone() {
        return new Ditch();
    }
}
