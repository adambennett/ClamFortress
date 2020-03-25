package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.concrete.faith;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural.*;

public class GoldenChurch extends AbstractFaithBuilding implements Golden {

    public GoldenChurch() {
        super("Golden Church", 650, 125, 200, new Gold());
    }

    @Override
    public Integer getGoldAmt() {
        return 450;
    }

    @Override
    public GoldenChurch clone() {
        return new GoldenChurch();
    }
}
