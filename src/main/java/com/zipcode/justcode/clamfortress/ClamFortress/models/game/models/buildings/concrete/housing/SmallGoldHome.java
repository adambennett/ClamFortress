package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.concrete.housing;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural.*;

public class SmallGoldHome extends AbstractHouse implements Golden {

    public SmallGoldHome() {
        super("Small Gold Home", 50, 550, new Gold());
    }

    @Override
    public Integer getGoldAmt() {
        return 500;
    }

    @Override
    public SmallGoldHome clone() {
        return new SmallGoldHome();
    }
}
