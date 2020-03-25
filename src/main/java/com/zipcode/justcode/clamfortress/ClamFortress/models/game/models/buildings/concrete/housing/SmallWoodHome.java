package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.concrete.housing;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural.*;

public class SmallWoodHome extends AbstractHouse {

    public SmallWoodHome() {
        super("Small Wood Home", 8, 100, new Wood());
    }

    @Override
    public SmallWoodHome clone() {
        return new SmallWoodHome();
    }
}
