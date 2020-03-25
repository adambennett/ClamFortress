package com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.plagues;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;

import java.util.concurrent.*;

public abstract class AbstractPlague extends AbstractEncounter {
    public AbstractPlague(String name, String desc, int turns) {
        super(name, desc, turns);
    }

    @Override
    public void runEncounter() {
        if (Game.getVillage().getInventory().containsItem("vaccine")) {
            if (ThreadLocalRandom.current().nextBoolean()) {
                Game.getVillage().addPlague(this);
            }
        } else {
            Game.getVillage().addPlague(this);
        }
    }
}
