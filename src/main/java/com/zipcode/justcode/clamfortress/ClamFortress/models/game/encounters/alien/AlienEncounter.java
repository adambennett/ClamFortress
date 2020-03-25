package com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.alien;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.beings.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.*;

import java.util.*;

public abstract class AlienEncounter extends AbstractEncounter {

    public AlienEncounter(String name, String desc, int turns) {
        super(name, desc, turns);
    }

    public abstract Map<AbstractResource, Integer> dropResources();

    public abstract ArrayList<Alien> invade();

    public abstract Integer dealDamage(AbstractNode underAtk);

    @Override
    public abstract void runEncounter();
}
