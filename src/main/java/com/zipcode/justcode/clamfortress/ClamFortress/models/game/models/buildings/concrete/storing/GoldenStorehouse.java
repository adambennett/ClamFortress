package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.concrete.storing;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural.*;

public class GoldenStorehouse extends AbstractStorehouse implements Golden {

    public GoldenStorehouse() {
        super("Golden Storehouse", 600, 3500, new Gold());
    }

    @Override
    public Integer getGoldAmt() {
        return 500;
    }


    @Override
    public GoldenStorehouse clone() {
        return new GoldenStorehouse();
    }
}
