package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.concrete.storing;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural.*;

public class RockStorehouse extends AbstractStorehouse {

    public RockStorehouse() {
        super("Rock Storehouse", 150, 2500, new Rock());
    }


    @Override
    public RockStorehouse clone() {
        return new RockStorehouse();
    }
}
