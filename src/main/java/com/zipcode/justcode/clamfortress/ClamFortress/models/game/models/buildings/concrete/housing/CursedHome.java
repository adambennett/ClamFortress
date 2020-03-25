package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.concrete.housing;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural.*;

public class CursedHome extends AbstractHouse implements Cursed {

    public CursedHome() {
        super("Cursed Home", 50, 200, new Clay());
    }

    @Override
    public CursedHome clone() {
        return new CursedHome();
    }
}
