package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.concrete.housing;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural.*;

public class LargeWoodHome extends AbstractHouse {

    public LargeWoodHome() {
        super("Large Wood Home", 20, 800, new Wood());
    }


    @Override
    public LargeWoodHome clone() {
        return new LargeWoodHome();
    }
}
