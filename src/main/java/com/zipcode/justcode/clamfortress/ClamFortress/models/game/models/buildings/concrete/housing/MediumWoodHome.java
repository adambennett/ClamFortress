package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.concrete.housing;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural.*;

public class MediumWoodHome extends AbstractHouse {

    public MediumWoodHome() {
        super("Medium Wood Home", 14, 400, new Wood());
    }

    @Override
    public MediumWoodHome clone() {
        return new MediumWoodHome();
    }

}
