package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.concrete.housing;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural.*;

public class LargeGoldHome extends AbstractHouse implements Golden {

    public LargeGoldHome() {
        super("Large Golden Home", 60, 1500, new Gold());
    }

    @Override
    public Integer getGoldAmt() {
        return 1000;
    }

    @Override
    public LargeGoldHome clone() {
        return new LargeGoldHome();
    }
}
