package com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.miracles;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes.*;

import javax.persistence.*;


public abstract class AbstractMiracle extends AbstractEncounter {

    public AbstractMiracle(String name, String desc, int turns) {
        super(name, desc, turns);
    }

    @Override
    public void runEncounter() {
        Game.getVillage().addMiracle(this);
    }


}
