package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.concrete.housing;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural.*;

public class MediumGoldHome extends AbstractHouse implements Golden {

    public MediumGoldHome() {
        super("Medium Golden Home", 55, 400, new Gold());
    }

    @Override
    public Integer getGoldAmt() {
        return 300;
    }

    @Override
    public MediumGoldHome clone() {
        return new MediumGoldHome();
    }
}
