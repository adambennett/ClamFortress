package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.concrete.defending;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural.*;

public class GoldenWatchtower extends AbstractDefenses implements Golden {

    public GoldenWatchtower() {
        super("Golden Watchtower", 500, 100, new Gold());
    }

    @Override
    public Integer getGoldAmt() {
        return 400;
    }

    @Override
    public GoldenWatchtower clone() {
        return new GoldenWatchtower();
    }
}
