package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.concrete.storing;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural.*;

public class CursedStorehouse extends AbstractStorehouse implements Cursed {

    public CursedStorehouse() {
        super("Cursed Storehouse", 50, 2000, new Clay());
    }

    @Override
    public CursedStorehouse clone() {
        return new CursedStorehouse();
    }
}
